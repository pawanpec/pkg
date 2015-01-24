package com.spedia.utils;

import java.util.List;
import java.util.Map;

public class SEOURLUtils {
	private static final String DISCOVER = "/discover/";
	private static final String INSIGHT = "/insight";
	private static final String NEWS = "/news";

	

	public static String getCompanySEOURL(String companyName, String companyId) {
		String url = DISCOVER + "company/";
		if (companyId != null) {
			url += companyId;
		}
		if (companyName != null) {
			url += "/" + removeSplChar(companyName).toLowerCase();
		}
		return url;

	}

	public static String getCompanyJobSEOURL(String companyName, String companyId) {
		String url = "/jobs/";
		if (companyId != null) {
			url += companyId;
		}
		if (companyName != null) {
			url += "/" + removeSplChar(companyName).toLowerCase();
		}
		return url;

	}

	public static String getCompanyReviewSEOURL(String companyName, String companyId) {
		StringBuffer reviewListURL = new StringBuffer("");
		StringBuffer queryStr = new StringBuffer("?");
		if (companyId != null) {
			queryStr.append("compids=");
			queryStr.append(companyId);
			reviewListURL.append(removeSplChar(companyName));
			reviewListURL.append("/");
		}
		String reviewListURLs = reviewListURL.toString().toLowerCase();
		reviewListURLs = reviewListURLs.replaceAll("-/", "/");
		reviewListURLs = reviewListURLs + queryStr.toString();
		return reviewListURLs;
	}

	public static String getCompanyInterviewSEOURL(String companyName, String companyId) {
		StringBuffer interviewListURL = new StringBuffer("");
		StringBuffer queryStr = new StringBuffer("?");
		if (companyId != null) {
			queryStr.append("compids=");
			queryStr.append(companyId);
			interviewListURL.append(removeSplChar(companyName));
			interviewListURL.append("/");
		}
		String interviewListURLs = interviewListURL.toString().toLowerCase();
		interviewListURLs = interviewListURLs.replaceAll("-/", "/");
		interviewListURLs = interviewListURLs + queryStr.toString();
		return interviewListURLs;
	}
	
	private static String removeSplChar(String str) {
			if(chkNull(str)){
				return "";
			}
			str = str.replaceAll("[^A-Za-z0-9]", " ");
			str = str.replaceAll("\\s+", "-");
			str = str.replaceAll("--", "-");
			return str.trim();
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
