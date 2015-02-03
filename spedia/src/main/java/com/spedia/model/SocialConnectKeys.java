package com.spedia.model;

public class SocialConnectKeys {
	/**api key/ api id**/
	private String apikey;
	
	/**api secret key**/
	private String appSecretKey;
	
	/**app Callback url**/
	private String appCallback;
	
	/**api class**/
	private String apiclass;
	
	/**api scope**/
	private String appScope;

	public String getApikey() {
		return apikey;
	}

	public SocialConnectKeys setApikey(String apikey) {
		this.apikey = apikey;
		return this;
	}

	public String getAppSecretKey() {
		return appSecretKey;
	}

	public SocialConnectKeys setAppSecretKey(String appSecretKey) {
		this.appSecretKey = appSecretKey;
		return this;
	}

	public String getAppCallback() {
		return appCallback;
	}

	public SocialConnectKeys setAppCallback(String appCallback) {
		this.appCallback = appCallback;
		return this;
	}

	public String getApiclass() {
		return apiclass;
	}

	public SocialConnectKeys setApiclass(String apiclass) {
		this.apiclass = apiclass;
		return this;
	}

	public String getAppScope() {
		return appScope;
	}

	public SocialConnectKeys setAppScope(String appScope) {
		this.appScope = appScope;
		return this;
	}
}
