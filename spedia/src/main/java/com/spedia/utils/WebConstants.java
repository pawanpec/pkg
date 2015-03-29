package com.spedia.utils;

public class WebConstants {
	public static final String IMAGE_URL ="/spedia/";// reader.getValue("image.context");//"/jobbuzz-web/"; //PropertyFileReader.getValue("IMAGE_URL");

	public static final String CSS_URL ="/spedia/";// reader.getValue("css.context");//"/jobbuzz-web/";
	public static final String JS_URL = "/spedia/";//reader.getValue("js.context");//"/jobbuzz-web/";
	public static final String APPLICATION_CONTEXT = "spedia";

	public static final Integer MAX_AUTO_SUGGEST = 3;
	
	public static final String source = "JOBBUZZ";

	public static final String SERVER_NAME = "http://test.schoolspedia.com/spedia/";//reader.getValue("server.name");// "http://socialtest.schoolspedia.com:8080/jobbuzz/";
	public static final String APPLICATION_URL = "http://test.schoolspedia.com/";//reader.getValue("application.url");

	public static final String NDATA_IMAGE_URL = "http://test.schoolspedia.com/spedia/";//reader.getValue("ndata.image.url"); //"http://53.jobbuzz.schoolspedia.com";
	public static final String LOGO_URL = NDATA_IMAGE_URL ;//+ reader.getValue("logo.url");
	public static final String BANNER_URL = NDATA_IMAGE_URL; //+ reader.getValue("banner.url");
	public static final String BACKGROUND_URL = NDATA_IMAGE_URL ;//+ reader.getValue("background.url");
	public static final String SUB_SECTION_URL = NDATA_IMAGE_URL ;//+ reader.getValue("subsection.url");
	public static final String PHOTOS_URL = NDATA_IMAGE_URL + "/ndata_images/company/photos/";//reader.getValue("photos.url");
	public static final String JOB_LANDING_URL = "all-jobs.html?datacenter=7&view=all&txtKeywords=";//reader.getValue("jobLanding.url");
	public static String FULLY_COOKIE_NAME = "FULLY_COOKIE_KEY";// ecm
	public static String HALF_COOKIE_NAME= "ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE";
	
	public static final int FULLY_COOKIE_VALIDITY_SECONDS = 30*60; //  30 MINS validity in seconds i.e 30*60
	public static final int HALF_COOKIE_VALIDITY_SECONDS = 60*60*24*14; //  14 days validity in seconds i.e 60*60*24*14
	
	public static String SECURITY_TOKEN="changeThis";
	public static String SP_DOMAIN = "test.schoolspedia.com";
	public static final String contentImageDirectory="/var/www/spedia/images/contentimages";
	public static final String schoolImageDirectory="/var/www/spedia/images/schoolimages";
}
