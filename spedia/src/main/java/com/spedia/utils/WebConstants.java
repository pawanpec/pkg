package com.spedia.utils;

import java.util.Locale;

public class WebConstants {
	public static String SP_DOMAIN = PropertyFileReader.getValue("SP_DOMAIN");
	public static final String IMAGE_URL ="/spedia/";
	public static final String CSS_URL ="/spedia/";
	public static final String JS_URL = "/spedia/";
	public static final String APPLICATION_CONTEXT = "spedia";
	public static final Integer MAX_AUTO_SUGGEST = 3;
	public static final String APPLICATION_URL = "http://"+SP_DOMAIN+"/";
	public static final String NDATA_IMAGE_URL = "http://"+SP_DOMAIN+"/"+"spedia/";
	public static final String LOGO_URL = NDATA_IMAGE_URL ;
	public static final String BANNER_URL = NDATA_IMAGE_URL; 
	public static final String BACKGROUND_URL = NDATA_IMAGE_URL ;
	public static final String SUB_SECTION_URL = NDATA_IMAGE_URL ;
	public static String FULLY_COOKIE_NAME = "FULLY_COOKIE_KEY";// ecm
	public static String HALF_COOKIE_NAME= "ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE";
	public static final int FULLY_COOKIE_VALIDITY_SECONDS = 30*60; //  30 MINS validity in seconds i.e 30*60
	public static final int HALF_COOKIE_VALIDITY_SECONDS = 60*60*24*14; //  14 days validity in seconds i.e 60*60*24*14
	public static String SECURITY_TOKEN="changeThis";
	public static final String contentImageDirectory="/var/www/spedia/images/contentimages";
	public static final String schoolImageDirectory="/var/www/spedia/images/schoolimages";
}
