package com.spedia.service;

import java.util.Map;

public interface ISocialActivityService {
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
	 * @throws Exception
	 */
	public void sendMail(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage, String userType)
			throws Exception;
	/**
	 * connectionMessage Map contains the the profile id and message. From login
	 * id we will fetch the profile who is sending the message to his
	 * connections
	 * 
	 * @param loginId
	 * @param provider
	 * @param connectionMessage
	 * @throws Exception
	 */
	public void postMessage(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage, String userType)
			throws Exception;
	
	
	public void postNotification(String appCode, String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage)
			throws Exception;
	
	public void postSocialNotification(String appCode, String loginId,
			String provider,Map<String, Map<String, String>> connectionMessage, 
			String userType)throws Exception;
	
	public String prepareDialogSendURL(String appCode,String loginId,
			String provider, String messageCaption, String link,
			String redirectUri, String description, String pictureUrl)
			throws Exception;
}
