package com.spedia.service;

import java.util.Map;

import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;

import com.spedia.model.SocialConnectKeys;
import com.spedia.utils.MyLogger;

public class SocialActivityService implements ISocialActivityService {
	@Autowired
	private SocialAuthServiceProvider socialAuthServiceProvider;
	private SocialServiceProvider socialServiceProvider;
	private ServiceImplementationProvider serviceImplementationProvider;
	private static final MyLogger logger = new MyLogger(SocialActivityService.class);
	
	@Override
	public void sendMail(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage, String userType) throws Exception {
		try{
			SocialConnectKeys keys = getSocialAuthServiceProvider().getSocialConnectKeys(appCode, provider);
			
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  getServiceImplementationProvider().getInstanceForSocialParser(provider);
			
			/**get the provider based social service implementation**/
			ISocialService socialService =  getSocialServiceProvider().getInstanceForSocialService(providerService.getProviderId());
			boolean status = socialService.sendMail(providerService, loginId, provider, connectionMessage, userType, appCode, keys);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void postMessage(String appCode,String loginId,
			String provider, Map<String, Map<String, String>> connectionMessage, String userType)
			throws Exception{
		try{
			/** creating the OAuthService object based on provider type **/
			OAuthService service = getSocialAuthServiceProvider().getOAuthServiceProvider(appCode, provider);
			logger.info("OAuthService created :"+service);
			SocialConnectKeys keys = getSocialAuthServiceProvider().getSocialConnectKeys(appCode, provider);
			logger.info("SocialConnectKeys created :"+keys);
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  getServiceImplementationProvider().getInstanceForSocialParser(provider);
			
			/**get the provider based social service implementation**/
			ISocialService socialService =  getSocialServiceProvider().getInstanceForSocialService(providerService.getProviderId());
			
			/**post the message**/
			socialService.postMessage(service, providerService, loginId, provider, connectionMessage, userType, appCode, keys);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void postNotification(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage)
			throws Exception {
		try{
			/** creating the OAuthService object based on provider type **/
			OAuthService service = getSocialAuthServiceProvider().getOAuthServiceProvider(appCode, provider);
			logger.info("OAuthService created :"+service);
			SocialConnectKeys keys = getSocialAuthServiceProvider().getSocialConnectKeys(appCode, provider);
			System.out.println("SocialConnectKeys created :"+keys);
			
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  getServiceImplementationProvider().getInstanceForSocialParser(provider);
			
			/**get the provider based social service implementation**/
			ISocialService socialService =  getSocialServiceProvider().getInstanceForSocialService(providerService.getProviderId());
			
			/**post the message**/
			socialService.postNotification(service, providerService, connectionMessage, keys);			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void postSocialNotification(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage, String userType)
			throws Exception {
		try{
			/** creating the OAuthService object based on provider type **/
			OAuthService service = getSocialAuthServiceProvider().getOAuthServiceProvider(appCode, provider);
			logger.info("OAuthService created :"+service);
			SocialConnectKeys keys = getSocialAuthServiceProvider().getSocialConnectKeys(appCode, provider);
			logger.info("SocialConnectKeys created :"+keys);
			
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  getServiceImplementationProvider().getInstanceForSocialParser(provider);
			
			/**get the provider based social service implementation**/
			ISocialService socialService =  getSocialServiceProvider().getInstanceForSocialService(providerService.getProviderId());
			
			/**post the notification**/
			socialService.postSocialNotification(service, providerService, loginId, provider, connectionMessage, userType, appCode, keys);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	
	public String prepareDialogSendURL(String appCode,String loginId,
			String provider, String messageCaption, String link,
			String redirectUri, String description, String pictureUrl)
			throws Exception{
		try{
			/** creating the OAuthService object based on provider type **/
			OAuthService service = getSocialAuthServiceProvider().getOAuthServiceProvider(appCode, provider);
			logger.info("OAuthService created :"+service);
			SocialConnectKeys keys = getSocialAuthServiceProvider().getSocialConnectKeys(appCode, provider);
			logger.info("SocialConnectKeys created :"+keys);
			/**creating the provider service implementation class**/
			OAuthProviderService providerService =  getServiceImplementationProvider().getInstanceForSocialParser(provider);
			
			/**get the provider based social service implementation**/
			ISocialService socialService =  getSocialServiceProvider().getInstanceForSocialService(providerService.getProviderId());
			
			/**prepare the feed URL**/
			return socialService.prepareDialogSendURL(service,
					providerService, loginId, provider, messageCaption, link,
					redirectUri, description, pictureUrl, keys);
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}

	public ServiceImplementationProvider getServiceImplementationProvider() {
		return serviceImplementationProvider;
	}

	public void setServiceImplementationProvider(
			ServiceImplementationProvider serviceImplementationProvider) {
		this.serviceImplementationProvider = serviceImplementationProvider;
	}

	public SocialAuthServiceProvider getSocialAuthServiceProvider() {
		return socialAuthServiceProvider;
	}

	public void setSocialAuthServiceProvider(
			SocialAuthServiceProvider socialAuthServiceProvider) {
		this.socialAuthServiceProvider = socialAuthServiceProvider;
	}

	public SocialServiceProvider getSocialServiceProvider() {
		return socialServiceProvider;
	}

	public void setSocialServiceProvider(
			SocialServiceProvider socialServiceProvider) {
		this.socialServiceProvider = socialServiceProvider;
	}
}