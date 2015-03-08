package com.spedia.utils;

import static com.spedia.utils.SessionAttributes.APP_CODE;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.spedia.utils.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;
import static com.spedia.utils.SessionAttributes.CLIENT_CALLBACK_URL;
import static com.spedia.utils.SessionAttributes.CLIENT_CALL_SOURCE;
import static com.spedia.utils.SessionAttributes.DATA_TYPE_REQUEST;
import static com.spedia.utils.SessionAttributes.LOGIN_ID_REQUEST;
import static com.spedia.utils.SessionAttributes.PROVIDER_ID_REQUEST;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.Token;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.spedia.model.Connection;
import com.spedia.model.User;
import com.spedia.model.UserRole;

public class SocialUtility {

	static class Wrapper<K, V extends Number & Comparable> implements
			Comparable<Wrapper> {
		K key;
		V value;

		K getKey() {
			return key;
		}

		void setKey(K key) {
			this.key = key;
		}

		V getValue() {
			return value;
		}

		void setValue(V value) {
			this.value = value;
		}

		@Override
		public int compareTo(Wrapper w) {
			return value.compareTo(w.getValue());
		}
	}

	public static boolean chkNull(Object value) {
		String strValue = null;

		if (value instanceof Integer) {
			strValue = value.toString();
		} else if (value instanceof Long) {
			strValue = value.toString();
		} else if (value instanceof String) {
			strValue = value.toString();
		}

		if (strValue == null || "".equals(strValue.trim())
				|| "-".equals(strValue.trim())
				|| "null".equals(strValue.trim())
				|| strValue.trim().length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * Provider data from are set in session in the form of Map<String,String>
	 * against the provider id. First we will get the Map against the provider
	 * id and then we will get the specific data from the Map
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static boolean isProviderDataInSession(HttpServletRequest request,
			String provider) {
		HttpSession session = request.getSession();
		String sessionProviderName = (String) session
				.getAttribute(PROVIDER_ID_REQUEST);
		if (provider.equals(sessionProviderName)) {
			return true;
		}
		return false;
	}

	/**
	 * Remove data from session if there is some error from the authorising
	 * sites
	 * 
	 * @param request
	 */
	public static void removeOtherProviderAuthTokenFromSession(
			HttpServletRequest request, String provider) {
		if (!isProviderDataInSession(request, provider)) {
			removeAuthTokenFromSession(request, provider);
		}
	}

	/**
	 * Remove data from session if there is some error from the authorising
	 * sites
	 * 
	 * @param request
	 */
	public static void removeAuthTokenFromSession(HttpServletRequest request,
			String provider) {
		HttpSession session = request.getSession();
		session.removeAttribute(ATTR_OAUTH_ACCESS_TOKEN);
		session.removeAttribute(ATTR_OAUTH_REQUEST_TOKEN);
	}

	public static String bsontojson(DBObject dbObject) {
		if (dbObject != null) {
			return null;
		}
		return null;
	}

	/**
	 * Iterate over the list of connections and fetch out the profile id's
	 * 
	 * @param connections
	 * @return
	 */
	public static String[] getConnectionsProfileId(List<Connection> connections) {
		if (connections != null && !connections.isEmpty()) {
			StringBuilder pid = new StringBuilder();
			Iterator<Connection> itr = connections.iterator();
			while (itr.hasNext()) {
				pid.append(itr.next().getPid()).append(" ");
			}
			return pid.toString().trim().split(" ");
		}
		return null;
	}

	public static DBObject jsontobson(String input) {
		if (!chkNull(input)) {
			DBObject object = (DBObject) JSON.parse(input);
			return object;
		}
		return null;
	}

	public static void addCookie(String key, String value,
			HttpServletResponse response) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, value);
			cookie.setDomain(WebConstants.SP_DOMAIN);
			cookie.setPath("/");
			cookie.setMaxAge(30 * 60);
			response.addCookie(cookie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void removeCookie(String key, HttpServletResponse response) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCookieByKey(HttpServletRequest req, String key) {
		Cookie[] cookies = req.getCookies();
		if (cookies == null || key == null) {
			return null;
		}
		String cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(key)) {
				cookie = cookies[i].getValue();
				break;
			}
		}
		return cookie;
	}

	/**
	 * Functionality which will take each and every word and will convert its
	 * first letter to its upper case
	 */
	public static String convertToSentence(String input) {
		if (input == null || "".equals(input.trim()))
			return "";
		String[] temp = input.trim().split("\\s");
		if (temp != null && temp.length > 0) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < temp.length; i++) {
				if (!"".equals(temp[i].trim())) {
					result.append(Character.toUpperCase(temp[i].charAt(0)))
							.append(temp[i].substring(1)).append(" ");
				}
			}
			return result.toString();
		}
		return "";
	}

	public static void storeDataInSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String provider = request.getParameter("pId");
		String loginId = request.getParameter("lid");
		String dataType = request.getParameter("dt");
		String callbackUrl = request.getParameter("cl");
		String callSource = request.getParameter("src") == null ? "tj"
				: request.getParameter("src");
		String appCode = request.getParameter("apc");
		String access_token = request.getParameter("access_token");
		Token accessToken=null;
		if (access_token!=null) {
			accessToken = new Token(access_token, "");
		}
		/**
		 * storing the information in session, which will be used in callback
		 * controller
		 **/
		if (!SocialUtility.chkNull(loginId))
			session.setAttribute(LOGIN_ID_REQUEST, loginId);
		if (!SocialUtility.chkNull(dataType))
			session.setAttribute(DATA_TYPE_REQUEST, dataType);
		if (!SocialUtility.chkNull(dataType))
			session.setAttribute(PROVIDER_ID_REQUEST, provider);
		if (!SocialUtility.chkNull(callbackUrl))
			session.setAttribute(CLIENT_CALLBACK_URL, callbackUrl);
		session.setAttribute(CLIENT_CALL_SOURCE, callSource);
		session.setAttribute(APP_CODE, appCode);
		if (!SocialUtility.chkNull(access_token))
			session.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken);
		System.out.println("CLIENT_CALLBACK_URL : " + callbackUrl
				+ " | session id " + session.getId() + " | app code "
				+ session.getAttribute(APP_CODE) + " | session data "
				+ session.getAttribute(CLIENT_CALLBACK_URL));
	}

	public static <K, V extends Number & Comparable> Map<K, V> sortMapnOnValues(
			Map<K, V> inputMap, boolean descending) {
		List<Wrapper<K, V>> wrappers = new ArrayList<Wrapper<K, V>>();
		for (Map.Entry<K, V> es : inputMap.entrySet()) {
			Wrapper<K, V> slw = new Wrapper<K, V>();
			slw.setKey(es.getKey());
			slw.setValue(es.getValue());
			wrappers.add(slw);
		}
		// Collections.sort(wrappers,
		// Collections.reverseOrder(getComparator()));
		Collections.sort(wrappers);
		if (descending) {
			Collections.reverse(wrappers);
		}
		// System.out.println("Between:" + wrappers);

		Map<K, V> newMap = new LinkedHashMap<K, V>();

		Iterator<Wrapper<K, V>> iter = wrappers.iterator();
		while (iter.hasNext()) {
			Wrapper<K, V> slw = iter.next();
			newMap.put(slw.getKey(), slw.getValue());
		}

		return newMap;
	}

	public static void setResultInResponse(HttpServletResponse resp,
			String result) {
		resp.setContentType("application/x-javascript");
		OutputStream os;
		try {
			os = resp.getOutputStream();
			os.write(result.getBytes());
			os.close();
		} catch (IOException e) {
			// Error while setting result in respones
			System.out.println("Written Response " + result);
		}
	}

	public static String getMD5(String message) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));

			return convertByteArrayToHexString(hashedBytes);
		} catch (Exception ex) {
		}
		return null;
	}

	public static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString(
					(arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}
	public static User getUserFromJson(String userJson){
		if (!chkNull(userJson)) {
			DBObject object = (DBObject) JSON.parse(userJson);
			User user=new User();
			String email=(String)object.get("email");
			String username=(String)object.get("username");
			String id=(String)object.get("id");
			user.setMail(email);
			user.setSocialLoginId(id);
			user.setUsername(username);
			Set<UserRole> userRoleses=new HashSet<UserRole>();
			UserRole userRole=new UserRole();
			userRole.setUser(user);
			userRole.setRole("ROLE_USER");
			userRoleses.add(userRole);
			user.setUserRoleses(userRoleses);
			return user;
		}
		return null;

	}
	
}
