package com.spedia.utils;

public class MongoConstants {
	
	public static final String MONGO_DB_NAME = "drupal";
	
	public static final String MONGO_DB_USER_PROFILE_COLLECTION = "profile";

	public static final String MONGO_DB_USER_CONNECTION_COLLECTION = "connections";
	public static final String MONGO_COLLECTION_PROFILEID = "pid";

	public static final String MONGO_COLLECTION_PROVIDER = "nid";
	public static final String MONGO_MIGRATION_STATUS = "ms";
	
	public static final String MONGO_COLLECTION_LOGINID = "lid";
	
	public static final String MONGO_COLLECTION_PARENT_PROFILEID = "ppid";

	public static final String MONGO_COLLECTION_PARENT_LOGINID = "plid";
	
	public static final String MONGO_COLLECTION_APP_CODE = "apc";
	
	public static final String MONGO_COLLECTION_CALL_SOURCE = "cs";
	
	public static final String MONGO_COLLECTION_DATA = "d";

	public static final String MONGO_COLLECTION_USER_PROFILE = "pf";
	
	public static final String MONGO_COLLECTION_STATUS = "st";

	public static final String MONGO_COLLECTION_TOKEN = "tk";

	public static final String MONGO_COLLECTION_USER_CONNECTION = "nt";

	public static final String MONGO_COLLECTION_TIMESTAMP = "ts";
	
	public static final String MONGO_COLLECTION_UPDATED_TIMESTAMP = "ut";
	
	public static final String MONGO_COLLECTION_EXPIRESON = "exp";
	
	/** providers constants **/
	public static final String MONGO_PROVIDER_FACEBOOK = "fb";
	
	public static final String MONGO_PROVIDER_TWITTER = "tw";
	
	public static final String MONGO_PROVIDER_LINKEDIN = "ln";
	
	/** token constants **/
	public static final String MONGO_ACCESS_TOKEN = "atk";
	
	public static final String MONGO_ACCESS_TOKEN_SECRET = "atks";
	
	public static final String MONGO_REQUEST_TOKEN = "rtk";
	
	public static final String MONGO_REQUEST_TOKEN_SECRET = "rtks";
	
	public static final String MONGO_OBJECT_ID = "_id";
	public static final int limit = 50000;
	public static final class PROFILE{

		public static final String NAME = "name";
		public static final String PID = MONGO_COLLECTION_PROFILEID;
		public static final String DATA = MONGO_COLLECTION_DATA;
		public static final String COLLECTION_NAME = MONGO_DB_USER_PROFILE_COLLECTION;
		public static final String CALL_SOURCE = MONGO_COLLECTION_CALL_SOURCE;
		public static final String PROVIDER_ID = MONGO_COLLECTION_PROVIDER;
		public static final String SCHOOL = "d.education.school";
		public static final String EMPLOYER = "d.work.employer";
		public static final String LOGIN_ID = MONGO_COLLECTION_LOGINID;
		public static final String DISPLAY_PICTURE = "dp";
		
	}

	
	
}
