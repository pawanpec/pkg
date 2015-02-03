package com.spedia.service;

import java.util.List;
import java.util.Map;

import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.spedia.model.Connection;
import com.spedia.model.Profile;
import com.spedia.model.SocialConnectKeys;

public interface ISocialService {
	public String saveProfile(Profile profile);

	public void saveConnections(Profile profile, List<Connection> connections);

	public String getProviderId();

	public Profile processUserProfile(Token accessToken, Token requestToken,
			OAuthProviderService providerService, Response oauthResponseUser);

	public List<Connection> processUserConnection(
			OAuthProviderService providerService, Response oauthResponseContact);

	/**
	 * connectionMessage Map contains the the profile id and message. From login
	 * id we will fetch the profile who is sending the message to his
	 * connections
	 * 
	 * @param service
	 * @param providerService
	 * @param loginId
	 * @param provider
	 * @param connectionMessage
	 * @param userType 
	 * @param keys 
	 * @throws Exception
	 */
	public void postMessage(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider, Map<String, Map<String, String>> connectionMessage, String userType, String appCode, SocialConnectKeys keys)
			throws Exception;

	/**
	 * connectionMessage Map contains the the profile id and message. From login
	 * id we will fetch the profile who is sending the message to his
	 * connections
	 * 
	 * @param service
	 * @param providerService
	 * @param loginId
	 * @param provider
	 * @param connectionMessage
	 * @param userType 
	 * @param keys 
	 * @throws Exception
	 */
	public boolean sendMail(OAuthProviderService providerService, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage, String userType, String appCode, SocialConnectKeys keys) throws Exception;
	/**
	 * Disconenct from the profile
	 * @param provider
	 * @param profileId
	 * @return
	 * @throws Exception
	 */
	public boolean disconnect(String provider, String profileId) throws Exception;

	/**
	 * A brief description about method. This just returns Profile object with pid,nid,cs and nid
	 * @param oauthResponseUser
	 * @return
	 * @author Mobicules.Tushar	
	 */
	public Profile getExistingProfile(Response oauthResponseUser);

	/**
	 * Updates this profile with requestToken and accessToken   
	 * @param profile
	 * @param requestToken
	 * @param accessToken
	 * @author Mobicules.Tushar	
	 */
	public void updateToken(Profile profile, Token requestToken,
			Token accessToken);
	
	
	public void postNotification(OAuthService service,
			OAuthProviderService providerService, Map<String, Map<String, String>> connectionMessage, SocialConnectKeys keys)
			throws Exception;
	
	/**
	 * connectionMessage Map contains the the profile id and message. From login
	 * id we will fetch the profile who is sending the notification to his
	 * connections
	 * 
	 * @param service
	 * @param providerService
	 * @param loginId
	 * @param provider
	 * @param connectionMessage
	 * @param userType 
	 * @param keys 
	 * @throws Exception
	 */
	public void postSocialNotification(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider, Map<String, Map<String, String>> connectionMessage, String userType, String appCode, SocialConnectKeys keys)
			throws Exception;
	
	/**
	 * This will prepare the feed URL to be called from the page for messaging
	 * and feeds to the user connections.
	 * 
	 * @param service
	 * @param providerService
	 * @param loginId
	 * @param provider
	 * @param connectionMessage
	 * @param userType
	 * @param appCode
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	public String prepareDialogSendURL(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider, String messageCaption, String link,
			String redirectUri, String description, String pictureUrl,
			SocialConnectKeys keys) throws Exception;
}
