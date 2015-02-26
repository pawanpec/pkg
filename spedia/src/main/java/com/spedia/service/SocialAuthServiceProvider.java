package com.spedia.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.oauth.OAuthService;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import com.spedia.model.SocialConnectKeys;
import com.spedia.utils.OAuthServiceConfig;
import com.spedia.utils.SocialUtility;



@Service("socialAuthServiceProvider")
public class SocialAuthServiceProvider implements Serializable , MessageSourceAware{
	private static final long serialVersionUID = 1L;
	private Map<String, Map<String, OAuthService>> providersMap;
	private Map<String, Map<String, SocialConnectKeys>> socialConnectKeys;
	private static final String APP_CODE_LIST   ="social.provider.app.code.list";
	private static final String PROVIDER_LIST   ="social.provider.list";
	private static final String APP_KEY         ="app.config.oauth.apikey";
	private static final String APP_SECRET_KEY  ="app.config.oauth.apisecret";
	private static final String CALLBACK_URL    ="app.config.oauth.callback";
	private static final String API_CLASS       ="app.config.oauth.apiclass";
	private static final String SCOPE           ="app.config.oauth.scope";
	public MessageSource messageSource;
	public SocialAuthServiceProvider() {}
	
	public OAuthService getOAuthServiceProvider(String appCode, String provider){
		if(providersMap.containsKey(appCode)){
			return (OAuthService) ((providersMap.get(appCode)).get(provider));	
		}
		return null;
	}
	
	public SocialConnectKeys getSocialConnectKeys(String appCode, String provider){
		if(socialConnectKeys.containsKey(appCode)){
			return (SocialConnectKeys) ((socialConnectKeys.get(appCode)).get(provider));	
		}
		return null;
	}
	
	public void init(){
		providersMap = new HashMap<String, Map<String, OAuthService>>();
		socialConnectKeys = new HashMap<String, Map<String, SocialConnectKeys>>();
		
		try{
			String appcodeList = 	messageSource.getMessage(APP_CODE_LIST,null,Locale.ENGLISH);
			if(!SocialUtility.chkNull(appcodeList) && !PROVIDER_LIST.equals(appcodeList)){
				Map<String, OAuthService> appProviderMap;
				Map<String, SocialConnectKeys> appKeysMap;
				
				String[] appIds = appcodeList.split(",");
				String appCode = "";
				/**iterate over the app name and fill the Map appProviderMap**/
				for(int j =0 ; j< appIds.length; j++){
					appCode = appIds[j];
					
					appProviderMap = new HashMap<String, OAuthService>();
					appKeysMap = new HashMap<String, SocialConnectKeys>();
					
					String providerList	=	messageSource.getMessage(PROVIDER_LIST,null,Locale.ENGLISH);
					if(!SocialUtility.chkNull(providerList) && !PROVIDER_LIST.equals(providerList)){
						String[] tokenenisedValue	=	providerList.split(",");
						String providerName	=	"";
						for(int i =0 ; i< tokenenisedValue.length; i++){
							providerName	=	tokenenisedValue[i];
							if(!SocialUtility.chkNull(providerName)){
								SocialConnectKeys 	keys 		= buildSocialConnectKeys(appCode, providerName);
								OAuthService 		authService = buildOAuthObject(keys);
								
								appProviderMap.put(providerName, authService);
								appKeysMap.put(providerName, keys);
							}
						}
					}
					
					providersMap.put(appCode, appProviderMap);
					socialConnectKeys.put(appCode, appKeysMap);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------------");
		System.out.println("----providersMap------"+providersMap);
		System.out.println("----socialConnectKeys------"+socialConnectKeys);
		System.out.println("--------------------------------------------------");
	}
	
	@SuppressWarnings("unchecked")
	private SocialConnectKeys buildSocialConnectKeys(String appCode,
			String provider) throws ClassNotFoundException {
		
		String apiclass  = messageSource.getMessage(appCode+"."+provider+"."+API_CLASS,null,Locale.ENGLISH);
		String apikey    = messageSource.getMessage(appCode+"."+provider+"."+APP_KEY,null,Locale.ENGLISH);
		String apisecret = messageSource.getMessage(appCode+"."+provider+"."+APP_SECRET_KEY,null,Locale.ENGLISH);
		String callback  = messageSource.getMessage(appCode+"."+provider+"."+CALLBACK_URL,null,Locale.ENGLISH);
		String scope  	 = messageSource.getMessage(appCode+"."+provider+"."+SCOPE,null,Locale.ENGLISH);
        
		SocialConnectKeys keys = new SocialConnectKeys().setApiclass(apiclass)
				.setApikey(apikey).setAppCallback(callback)
				.setAppScope(scope).setAppSecretKey(apisecret);

		return keys;
	}
	
	@SuppressWarnings("unchecked")
	private OAuthService buildOAuthObject(SocialConnectKeys keys) throws ClassNotFoundException{
		OAuthServiceConfig config = new OAuthServiceConfig(keys.getApikey(),
				keys.getAppSecretKey(), keys.getAppCallback(),
				(Class<? extends Api>) Class.forName(keys.getApiclass()));
		
		ServiceBuilder serviceBuilder = new ServiceBuilder()
				.provider(config.getApiClass()).apiKey(config.getApiKey())
				.apiSecret(config.getApiSecret())
				.callback(config.getCallback());
		
		if(!SocialUtility.chkNull(keys.getAppScope())){
			serviceBuilder.scope(keys.getAppScope());
		}
		return serviceBuilder.build();
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
		//init();
	}

}
