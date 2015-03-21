package com.spedia.utils;


public class SEOURLUtils {
	private static final int TITLE_IN_URL_MAX_LENGTH = 100;

	public static String getSEOURL(String type, String title) {
		// build the title that appears in the URL when accessing a podcast from
		// the main application
		String titleInUrl = title.trim()
				.replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
		titleInUrl = removeSplChar(titleInUrl);
		type=removeSplChar(type);
		titleInUrl=type+"/"+titleInUrl;
		if (titleInUrl.length() > TITLE_IN_URL_MAX_LENGTH) {
			titleInUrl = titleInUrl.substring(0, TITLE_IN_URL_MAX_LENGTH);
		}
		return titleInUrl.toLowerCase();

	}
	private static String removeSplChar(String str) {
		if (!chkNull(str)) {
			str = str.replaceAll("[^A-Za-z0-9]", " ");
			str = str.replaceAll("\\s+", "-");
			str = str.replaceAll("--", "-");
			str = str.replaceAll("[\\-| |\\.]+", "-");
			return str.trim();
		} else {
			return "";
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


}
