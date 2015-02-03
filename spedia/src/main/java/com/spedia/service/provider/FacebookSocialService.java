package com.spedia.service.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spedia.dao.MongoDao;
import com.spedia.model.Connection;
import com.spedia.model.ConnectionBuilder;
import com.spedia.model.Profile;
import com.spedia.model.ProfileBuilder;
import com.spedia.model.SocialConnectKeys;
import com.spedia.service.ISocialService;
import com.spedia.service.OAuthProviderService;
import com.spedia.utils.MyLogger;

@Service("facebookSocialService")
public class FacebookSocialService implements ISocialService {
	private static final MyLogger logger = new MyLogger(FacebookSocialService.class);
	@Autowired
	private MongoDao mongoDao;
	
	public static final String providerId = "fb";

	@Override
	public String getProviderId() {
		return providerId;
	}

	@Override
	public String saveProfile(Profile profile) {
		return mongoDao.saveProfile(profile);
	}

	@Override
	public void saveConnections(Profile profile, List<Connection> connections) {
		mongoDao.saveConnections(profile, connections);
	}

	/**
	 * Process user profile data and save/update in mongo db 1. Provide code 2.
	 * BSON data 3. profile id 4. access/request token 5. expires-on
	 * 
	 * @param providerService
	 * @param oauthResponseUser
	 * @return
	 */
	@Override
	public Profile processUserProfile(Token accessToken, Token requestToken,
			OAuthProviderService providerService, Response oauthResponseUser) {
		String acsToken = null, acsTokenSecret = null, reqToken = null, reqTokenSecret = null;
		if (accessToken != null) {
			acsToken = accessToken.getToken();
			acsTokenSecret = accessToken.getSecret();
		}
		if (requestToken != null) {
			reqToken = requestToken.getToken();
			reqTokenSecret = requestToken.getSecret();
		}
		/** build profile object **/
		String presp = oauthResponseUser.getBody();

		try {
			JSONObject resp = new JSONObject(presp);
			Profile profile = new ProfileBuilder()
					.buildWithAccessToken(acsToken)
					.buildWithAcsTokenSecret(acsTokenSecret)
					.buildWithReqToken(reqToken)
					.buildWithReqTokenSecret(reqTokenSecret)
					.buildWithProvider(providerId).buildWithStatus(1)
					.buildWithProfileId(resp.getString("id"))
					.buildWithData(oauthResponseUser.getBody()).build();
			return profile;
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Iterate the user connection and build the list of Connection objects
	 * 
	 * @throws JSONException
	 */
	@Override
	public List<Connection> processUserConnection(
			OAuthProviderService providerService, Response oauthResponseContact) {
		if (oauthResponseContact != null
				&& oauthResponseContact.getBody() != null) {
			String respStr = oauthResponseContact.getBody();
			List<Connection> clist = new ArrayList<Connection>();
			try {
				JSONObject resp = new JSONObject(respStr);
				JSONArray data = resp.getJSONArray("data");
				for (int i = 0; i < data.length(); i++) {
					JSONObject obj = data.getJSONObject(i);
					Connection connection = new ConnectionBuilder()
							.buildWithData(obj.toString())
							.buildWithProfileId(obj.getString("id"))
							.buildWithProvider(providerId).build();

					clist.add(connection);
				}
				return clist;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	@Override
	public boolean disconnect(String provider, String profileId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void postMessage(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider,
			Map<String, Map<String, String>> connectionMessage,
			String userType, String appCode, SocialConnectKeys keys)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sendMail(OAuthProviderService providerService,
			String loginId, String provider,
			Map<String, Map<String, String>> connectionMessage,
			String userType, String appCode, SocialConnectKeys keys)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postNotification(OAuthService service,
			OAuthProviderService providerService,
			Map<String, Map<String, String>> connectionMessage,
			SocialConnectKeys keys) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSocialNotification(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider,
			Map<String, Map<String, String>> connectionMessage,
			String userType, String appCode, SocialConnectKeys keys)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String prepareDialogSendURL(OAuthService service,
			OAuthProviderService providerService, String loginId,
			String provider, String messageCaption, String link,
			String redirectUri, String description, String pictureUrl,
			SocialConnectKeys keys) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile getExistingProfile(Response oauthResponseUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateToken(Profile profile, Token requestToken,
			Token accessToken) {
		// TODO Auto-generated method stub
		
	}

	
}
