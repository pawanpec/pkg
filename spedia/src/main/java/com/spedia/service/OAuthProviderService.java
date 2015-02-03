package com.spedia.service;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.scribe.model.Response;
import org.scribe.oauth.OAuthService;



public interface OAuthProviderService extends Serializable {
	
	/**
	 * Retrieves the provider id
	 * 
	 * @return provider id.
	 */
	public String getProviderId();
	
	/**
	 * Retrieves the user profile.
	 * 
	 * @return Response object containing the profile information.
	 * @throws Exception
	 */
	public Response getUserProfile(OAuthService service, HttpServletRequest request) throws Exception;
	
	/**
	 * Gets the list of contacts of the user and their email. this may not be
	 * available for all providers.
	 * 
	 * @return List of profile objects representing Contacts. Only name and
	 *         email will be available
	 */
	public Response getContactList(OAuthService service, HttpServletRequest request) throws Exception;
	
	/**
	 * Checks whether the Token is available in session or not Token are AccessToken/RequestToken based on the provider's implementation
	 * Facebook uses - AccessToken only (OAuth2.0) where as Others uses AccessToken and Request Token both (0Auth1.0) 
	 *  
	 * @param msg
	 *            Message to be shown as user's status
	 */
	public boolean isSessionTokenAvailable(HttpServletRequest request);
	
	/**
	 * Returns the provider based authorisation URL
	 *  
	 *  
	 * @param msg
	 *            Message to be shown as user's status
	 */
	public String getAuthorizationUrl(OAuthService service,HttpServletRequest request);
	
	/**
	 * Returns user profile with an extended token
	 * @param service
	 * @param request
	 * @return
	 * @throws Exception
	 * @author Mobicules.Tushar	
	 */
	Response getUserProfileWithExtendedToken(OAuthService service,
			HttpServletRequest request) throws Exception;
	/**
	 * 
	 */
}
