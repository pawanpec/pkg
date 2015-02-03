package com.spedia.service.impl;

import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Service;

import com.spedia.service.OAuthProviderService;
@Service("linkedinAuthServiceProvider")
public class LinkedinOAuthProviderServiceImpl implements OAuthProviderService{
	private static final long serialVersionUID = 3189534747649988389L;
	public static final String providerId = "ln";
	
	private static final String PROFILE_URL = "http://api.linkedin.com/v1/people/~:";
	private static final String CONTACTS_URL = "http://api.linkedin.com/v1/people/~/connections:";
	private static final String PROFILE_FIELDS = "(id,first-name,last-name,email-address,headline,distance,specialties,summary,positions,skills,certifications,educations,courses,phone-numbers,industry,date-of-birth,picture-url,public-profile-url,honors,interests,patents,recommendations-received,location:(name))";
	private static final String FRIENDS_FIELDS = "(id,first-name,last-name,headline,distance,summary,specialties,positions,industry,date-of-birth,picture-url,public-profile-url,location:(name))";

	private static final String UPDATE_STATUS_URL = "http://api.linkedin.com/v1/people/~/shares";
	private static final String STATUS_BODY = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><share><comment>%1$s</comment><visibility><code>anyone</code></visibility></share>";

	@Override
	public String getProviderId() {
		return providerId;
	}
	
	@Override
	public Response getUserProfile(OAuthService service,
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		
		// getting access token
		if(accessToken==null){
			String oauthVerifier = request.getParameter("oauth_verifier");
			System.out.println("oauthVerifier :- "+oauthVerifier);
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			System.out.println("oauthVerifier accessToken :- "+accessToken);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,PROFILE_URL+PROFILE_FIELDS);
		oauthRequest.addHeader("x-li-format", "json");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		
		return oauthResponse;
	}
	
	@Override
	public Response getContactList(OAuthService service, HttpServletRequest request) throws Exception  {
		HttpSession session = request.getSession();
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		
		if(accessToken==null){
			String oauthVerifier = request.getParameter("oauth_verifier");
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,CONTACTS_URL+FRIENDS_FIELDS);
		oauthRequest.addHeader("x-li-format", "json");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		return oauthResponse;
	}

	public boolean isSessionTokenAvailable(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		
		if(accessToken == null || requestToken == null) {
			return false;
		}
		return true;
	}

	@Override
	public String getAuthorizationUrl(OAuthService service,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("provider asif 355-1: "+service);
		Token requestToken = service.getRequestToken();
		System.out.println("provider asif 355: "+requestToken);
		session.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken);
		
		return service.getAuthorizationUrl(requestToken);
	}


	/* (non-Javadoc)
	 * @see com.tj.cand.social.service.OAuthProviderService#getUserProfileWithExtendedToken(org.scribe.oauth.OAuthService, javax.servlet.http.HttpServletRequest)
	 * @author mobicules
	 */
	@Override
	public Response getUserProfileWithExtendedToken(OAuthService service,
			HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
