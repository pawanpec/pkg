package com.spedia.controller;

import static com.spedia.utils.SessionAttributes.APP_CODE;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;
import static com.spedia.utils.SessionAttributes.CLIENT_CALLBACK_URL;
import static com.spedia.utils.SessionAttributes.CLIENT_CALL_SOURCE;
import static com.spedia.utils.SessionAttributes.DATA_TYPE_REQUEST;
import static com.spedia.utils.SessionAttributes.LOGIN_ID_REQUEST;
import static com.spedia.utils.SessionAttributes.RETRY;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.spedia.dao.MongoDao;
import com.spedia.model.Connection;
import com.spedia.model.Profile;
import com.spedia.service.ISocialService;
import com.spedia.service.OAuthProviderService;
import com.spedia.service.ServiceImplementationProvider;
import com.spedia.service.SocialAuthServiceProvider;
import com.spedia.service.SocialServiceProvider;
import com.spedia.utils.MyLogger;
import com.spedia.utils.SocialUtility;
/**
 * This class fetches the social data after authentication the user from the respective site.
 * 
 */
@Controller
public class CallbackController {
	private static final MyLogger logger = new MyLogger(CallbackController.class);
	@Autowired
	private SocialAuthServiceProvider socialAuthServiceProvider; 
	@Autowired
	private ServiceImplementationProvider serviceImplementationProvider;
	@Autowired
	private SocialServiceProvider socialServiceProvider;
	@Autowired
	MongoDao mongoDao;
	private ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
		   @Override
		   public Thread newThread(Runnable runnable) {
		      Thread thread = Executors.defaultThreadFactory().newThread(runnable);
		      thread.setDaemon(true);
		      return thread;
		   }
		});
	
	@RequestMapping(value = { "/callback.html" }, method = { RequestMethod.GET })
	public ModelAndView callback(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		final String provider  = request.getParameter("pId");
		final String appCode  = request.getParameter("apc");
		String dataType = (String)session.getAttribute(DATA_TYPE_REQUEST);
		
		Response oauthResponseUser = null;
		Response oauthResponseContact = null;
		
		Map<String,String> model	=	new HashMap<String,String>();
		
		try{
			/**creating the OAuthService object based on provider type**/
			OAuthService service = 		socialAuthServiceProvider.getOAuthServiceProvider(appCode, provider);
			
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  serviceImplementationProvider.getInstanceForSocialParser(provider);
			
			if(!SocialUtility.chkNull(dataType) && dataType.indexOf("pf") >= 0){
				oauthResponseUser = providerService.getUserProfile(service, request);
			}else if(!SocialUtility.chkNull(dataType) && dataType.indexOf("nt") >= 0){
				oauthResponseContact = providerService.getContactList(service, request);
			}else{
				oauthResponseUser = providerService.getUserProfile(service, request);
				oauthResponseContact = providerService.getContactList(service, request);
			}
			
			int code = getResponseCode(oauthResponseUser, oauthResponseContact);
			int retry = getRetryCount(request);
			/**
			 * If response is not 200 then give 1 try after the retyr if again
			 * error is coming the redirect the user to the callback url with
			 * error code
			 */
			if(code != 200){
				if(retry == 0){
					session.setAttribute(RETRY, new Integer(1));
					removeDataFromSession(request);
					return new ModelAndView("redirect:"+createSocialControllerURL(request, provider));
				}else{
					model.put("error",""+code);	
				}
			}
			
			/**call the caller application call-back URL**/
			final String pid=processData(providerService, oauthResponseUser, oauthResponseContact, request);
			DBObject dbObject=mongoDao.getUserProfileByProfileID(pid, appCode);
			model.put("profileID", pid);
			model.put("provider", provider);
		}catch(Exception e){
			e.printStackTrace();
			model.put("error", "exception");
		}
		SocialUtility.removeAuthTokenFromSession(request, provider);
		System.out.println("Data from :"+provider+" are logged into the mongo db, now redirecting with profileID to the callback URL.");
		return new ModelAndView("redirect:"+prepareCallbackURL(request, model));
		//return new ModelAndView("dataPage",model);
	}
	/**
	 * Process the user data and user connections
	 * @param providerService 
	 * @param oauthResponseUser
	 * @param oauthResponseContact
	 * @param request 
	 * @return
	 * @throws Exception 
	 */
	private String processData(OAuthProviderService providerService, Response oauthResponseUser,
			Response oauthResponseContact, HttpServletRequest request)throws Exception {
		
		HttpSession session = request.getSession();
		/**get the provider based social service implementation**/
		ISocialService socialService =  socialServiceProvider.getInstanceForSocialService(providerService.getProviderId());
		
		/**get token from session**/
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		
		/**track the call source **/
		String callSource = (String)session.getAttribute(CLIENT_CALL_SOURCE);
		
		/**track the login-id **/
		String loginId = (String)session.getAttribute(LOGIN_ID_REQUEST);
		
		/**track the appcode of the calling source**/
		String appCode = (String)session.getAttribute(APP_CODE);
		
		/**
		 * before inserting the user profile, if user connection is also there
		 * then process the user connection and find out the profile id's
		 **/
		List<Connection> connections = socialService.processUserConnection(providerService, oauthResponseContact);
		
		/**save or update the user profile**/
		Profile  profile = socialService.processUserProfile(accessToken,requestToken, providerService, oauthResponseUser);
		profile.setCs(callSource);
		profile.setApc(appCode);	
		if(!SocialUtility.chkNull(loginId)){
			profile.setLid(loginId);	
		}		
		
		/**save the profile and connections**/
		if(profile != null)
			socialService.saveProfile(profile);
		if(connections != null)
			socialService.saveConnections(profile, connections);
		
		/**return the user profile id**/
		return profile.getPid().toString();
	}
	/**
	 * From the profile or connection response, get the response code 
	 * @param oauthResponseUser
	 * @param oauthResponseContact
	 * @return
	 */
	private int getResponseCode(Response oauthResponseUser, Response oauthResponseContact){
		if(oauthResponseUser != null){
			return oauthResponseUser.getCode();
		}else if(oauthResponseContact != null){
			return oauthResponseContact.getCode();
		}
		return 0;
	}
	private int getRetryCount(HttpServletRequest request){
		HttpSession session = request.getSession();
		int count = 0;
		Integer retry = (Integer) session.getAttribute(RETRY);
		if(retry != null){
			count = retry.intValue();
			session.removeAttribute(RETRY);
		}
		return count;
	}
	/**
	 * Remove data from session if there is some error from the authorising sites
	 * @param request
	 */
	private void removeDataFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		session.removeAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		session.removeAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		session.removeAttribute(LOGIN_ID_REQUEST);
		session.removeAttribute(DATA_TYPE_REQUEST);
		session.removeAttribute(CLIENT_CALLBACK_URL);
	}
	/**
	 * Creating the social controller url for re authorising
	 * @param request
	 * @param provider 
	 * @return
	 */
	private String createSocialControllerURL(HttpServletRequest request, String provider){
		HttpSession session = request.getSession();
		
		String loginId      = (String)session.getAttribute(LOGIN_ID_REQUEST);
		String dataType 	= (String)session.getAttribute(DATA_TYPE_REQUEST);
		String callbackUrl  = (String)session.getAttribute(CLIENT_CALLBACK_URL);
		String callSource  = (String)session.getAttribute(CLIENT_CALL_SOURCE);
		String appCode     = (String)session.getAttribute(APP_CODE);
		
		System.out.println("RETRY URL  pId=" + provider + "&lid=" + loginId
				+ "&dt=" + dataType + "&cl=" + callbackUrl + "&outSource="
				+ callSource + "&apc=" + appCode);
		
		return "/social-connect.html?pId=" + provider + "&lid=" + loginId
				+ "&dt=" + dataType + "&cl=" + callbackUrl + "&outSource="
				+ callSource + "&apc=" + appCode;
	}
	/**
	 * Prepare the Callback URL to which the response has to be sent
	 * @param request
	 * @return
	 */
	private String prepareCallbackURL(HttpServletRequest request, Map<String,String> model){
		HttpSession session = request.getSession();
		String callbackURL = (String)session.getAttribute(CLIENT_CALLBACK_URL);
		String callSource  = (String)session.getAttribute(CLIENT_CALL_SOURCE);
		String appCode     = (String)session.getAttribute(APP_CODE);
		
		System.out.println("CLIENT_CALLBACK_URL : "+callbackURL+ " | session id "+session.getId()+" | model data "+model);
		try {
			callbackURL = URLDecoder.decode(callbackURL,"UTF-8");
			String queryString = "";
			if(model.containsKey("error")){
				queryString = "st="+model.get("error")+"&pId="+model.get("provider")+"&outSource="+callSource+"&apc="+appCode;
			}else if(model.containsKey("profileID")){
				queryString = "st=s&pfId="+model.get("profileID")+"&pId="+model.get("provider")+"&outSource="+callSource+"&apc="+appCode;
			}
			callbackURL += "";
			if(callbackURL  != null && callbackURL.indexOf("?") >= 0){
				callbackURL += "&"+queryString;
			}else{
				callbackURL += "?"+queryString;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return callbackURL;
	}
}
