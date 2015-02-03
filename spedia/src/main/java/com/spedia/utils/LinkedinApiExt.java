package com.spedia.utils;

import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.Token;

public class LinkedinApiExt extends LinkedInApi {

	private static final String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authenticate?oauth_token=%s";

	@Override
	public String getAccessTokenEndpoint() {
		return "https://api.linkedin.com/uas/oauth/accessToken";
	}

	@Override
	public String getRequestTokenEndpoint() {
		return "https://api.linkedin.com/uas/oauth/requestToken?scope=r_basicprofile+r_emailaddress+r_fullprofile+r_contactinfo+r_network+w_messages";
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return String.format(AUTHORIZE_URL, requestToken.getToken());
	}

}
