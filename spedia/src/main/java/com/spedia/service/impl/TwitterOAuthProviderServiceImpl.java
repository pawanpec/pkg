package com.spedia.service.impl;

import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Service;

import com.spedia.service.OAuthProviderService;
import com.spedia.utils.Constants;
import com.spedia.utils.SocialUtility;
@Service("twitterAuthServiceProvider")
public class TwitterOAuthProviderServiceImpl implements OAuthProviderService{
	private static final long serialVersionUID = 4767284106714933472L;

	public static final String providerId = "tw";
	
	private static final String PROFILE_URL = "https://api.twitter.com/1/account/verify_credentials.json";
	private static final String CONTACTS_URL = "https://api.twitter.com/1/friends/ids.json?cursor=-1&screen_name=";
	
	private static final String LOOKUP_URL = "http://api.twitter.com/1/users/lookup.json?user_id=";
	private static final String UPDATE_STATUS_URL = "http://api.twitter.com/1/statuses/update.json?status=";
	
	@Override
	public String getProviderId() {
		return providerId;
	}
	@Override
	public Response getUserProfile(OAuthService service, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		// getting access token
		if(accessToken==null){
			String oauthVerifier = request.getParameter("oauth_verifier");
			String oauth_token = request.getParameter("oauth_token");
			
			requestToken = new Token(oauth_token,oauthVerifier);
			session.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken);
			
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,PROFILE_URL);
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		//fetch the screen name and set in the request as request attribute
		fetchUserScreenName(oauthResponse, request);
		return oauthResponse;
	}

	@Override
	public Response getContactList(OAuthService service, HttpServletRequest request) throws Exception  {
		HttpSession session = request.getSession();
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		
		if(accessToken==null){
			String oauthVerifier = request.getParameter("oauth_verifier");
			String oauth_token = request.getParameter("oauth_token");
			
			requestToken = new Token(oauth_token,oauthVerifier);
			session.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken);
			
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		String screenName = (String)request.getAttribute(Constants.TWITTER_SCREEN_NAME);
		if(!SocialUtility.chkNull(screenName)){
			OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,CONTACTS_URL+screenName);
			service.signRequest(accessToken, oauthRequest);
			Response oauthResponse = oauthRequest.send();
			
			/**get the id's from the connection URL response and call lookup url to get the data of all the connections**/
			return fetchConnectionInformation(oauthResponse, request, service);
		}
		return null;
	}
	/**
	 * @param oauthResponse
	 * @param request
	 * @param service
	 */
	private Response fetchConnectionInformation(Response oauthResponse ,HttpServletRequest request, OAuthService service){
		String presp = oauthResponse.getBody();
		try {
			JSONObject resp = new JSONObject(presp);
			JSONArray ids = resp.getJSONArray("ids");
			String userId1 = ids.toString();
			if(ids != null){
				String userIds = "";
				for(int i = 0 ; i < ids.length(); i++){
					userIds += ids.get(i)+",";
				}
				return lookupUsers(userIds, request, service);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Response lookupUsers(String userIds,HttpServletRequest request, OAuthService service) throws Exception {
		HttpSession session = request.getSession();
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		
		if(accessToken==null){
			String oauthVerifier = request.getParameter("oauth_verifier");
			String oauth_token = request.getParameter("oauth_token");
			
			requestToken = new Token(oauth_token,oauthVerifier);
			session.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken);
			
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, LOOKUP_URL + userIds);
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponseContact = oauthRequest.send();
		return oauthResponseContact;
	}
	/**
	 * fetch out the user screen name and id from the oauth response object
	 * @param oauthResponseUser
	 * @param request
	 */
	private void fetchUserScreenName(Response oauthResponseUser, HttpServletRequest request){
		String presp = oauthResponseUser.getBody();
		try {
			JSONObject resp = new JSONObject(presp);
			String screenName = resp.getString("screen_name");
			String twitterUserId = resp.getString("id_str");
			request.setAttribute(Constants.TWITTER_SCREEN_NAME, screenName);
			request.setAttribute(Constants.TWITTER_USER_ID, twitterUserId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isSessionTokenAvailable(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		if(accessToken == null) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.spedia.utils.service.OAuthProviderService#getUserProfileWithExtendedToken(org.scribe.oauth.OAuthService, javax.servlet.http.HttpServletRequest)
	 * @author mobicules
	 */
	@Override
	public Response getUserProfileWithExtendedToken(OAuthService service,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getAuthorizationUrl(OAuthService service,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
