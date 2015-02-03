package com.spedia.service.impl;

import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

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
import com.spedia.utils.Constants;
@Service("facebookAuthServiceProvider")
public class FacebookOAuthProviderServiceImpl implements OAuthProviderService{
	private static final long serialVersionUID = -6250692839727733106L;

	public static final String providerId = "fb";
	public static final String profileIDConstant = "0profileID0";

	private static final String PROFILE_URL = "https://graph.facebook.com/me";
	private static final String PROFILE_FIELDS = "id,name,email,username,work,education,gender,birthday,location";
	private static final String FRIENDS_FIELDS = "id,name,email,username,birthday,gender,education,work";
	private static final String CONTACTS_URL = "https://graph.facebook.com/me/friends";
	
	private static final String POST_MESSAGE_URL = "https://graph.facebook.com/"+profileIDConstant+"/feed/";
	private static final String PROFILE_IMAGE_URL = "http://graph.facebook.com/%1$s/picture";
	private static final String PUBLIC_PROFILE_URL = "http://www.facebook.com/profile.php?id=";
	
	private static final String POST_NOTIFICATION_URL = "https://graph.facebook.com/"+profileIDConstant+"/notifications/";
	private static final String DIALOG_SEND_URL = "https://www.facebook.com/dialog/send";
	
	private static final String TOKEN_EXCHANGE_URL = "https://graph.facebook.com/oauth/access_token";

	private static final String PROFILE_FIELDS_JB = "id,name,email,username,work,education,gender,birthday,location";
	
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
			String oauthVerifier = request.getParameter("code");
			System.out.println("oauthVerifier :- "+oauthVerifier);
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			System.out.println("oauthVerifier accessToken :- "+accessToken);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,PROFILE_URL+"?fields="+PROFILE_FIELDS);
		
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		return oauthResponse;
	}
	
	
	
	@Override
	public Response getContactList(OAuthService service, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		/*
		 * Getting access token from request for jb app
		 */
		String access_token 	= request.getParameter("access_token");
		if(accessToken==null&&access_token!=null){
			accessToken = new Token(access_token, "");
		}
		// getting access token
		if(accessToken==null){
			String oauthVerifier = request.getParameter("code");
			Verifier verifier = new Verifier(oauthVerifier);
			accessToken = service.getAccessToken(requestToken, verifier);
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,CONTACTS_URL+"?fields="+FRIENDS_FIELDS);
		
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		return oauthResponse;
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

	@Override
	public String getAuthorizationUrl(OAuthService service, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, null);
		return service.getAuthorizationUrl(null);
		
	}

	
	
	@Override
	public Response getUserProfileWithExtendedToken(OAuthService service, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		Token accessToken = (Token) session.getAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		// getting access token
		if(accessToken==null){
			 String access_token 	= request.getParameter("access_token");
			 accessToken = new Token(access_token, "");
			 System.out.println("accessToken value="+access_token);
			 if(access_token==null){
				Token requestToken = (Token) session.getAttribute(ATTR_OAUTH_REQUEST_TOKEN);
				String oauthVerifier = request.getParameter("code");
				System.out.println("oauthVerifier :- "+oauthVerifier);
				Verifier verifier = new Verifier(oauthVerifier);
				accessToken = getExtendedToken(service.getAccessToken(requestToken, verifier));
				System.out.println("oauthVerifier accessToken :- "+accessToken);
			}
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		}
		
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET,PROFILE_URL+"?fields="+PROFILE_FIELDS_JB);
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		
		return oauthResponse;
	}

	/**
	 * Get extended token thats valid for 60 days
	 * 
	 * @param accessToken
	 * @return
	 * @author Mobicules.Tushar
	 */
	private Token getExtendedToken(Token accessToken) {

		try {
			InputStream is = new URL(TOKEN_EXCHANGE_URL + "?"
					+ "grant_type=fb_exchange_token&client_id="
					+ Constants.APP_ID + "&client_secret="
					+ Constants.APP_SECRET_FB + "&fb_exchange_token="
					+ accessToken.getToken()).openConnection().getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String response = in.readLine();
			in.close();
			String token = response.substring(response.indexOf('=') + 1,
					response.indexOf('&'));
			accessToken = new Token(token, "");
		} catch (Exception e) {
		}
		return accessToken;
	}


}
