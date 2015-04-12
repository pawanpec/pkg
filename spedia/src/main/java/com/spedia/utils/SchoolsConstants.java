package com.spedia.utils;


/**
 *
 */
public class SchoolsConstants {
	
	public static String INDEX_PATH = "/var/www/spedia/auto";
	
	/**
	 * sources
	 */
	public static final String SOURCE_TYPE_JOBBUZZ = "JOBBUZZ";
	
	/**
	 * Compare To Variables
	 */
	public static final int BEFORE = -1;
	public static final int EQUAL = 0;
	public static final int AFTER = 1;
	
	/**
	 * Roles in the system
	 */
	public static final String ROLE_CANDIDATE = "ROLE_CANDIDATE";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_EMPLOYER = "ROLE_EMPLOYER";
	
	/**
	 * Roles in the system
	 */
	public static final Long ROLE_CANDIDATE_VALUE = 1L;
	public static final Long ROLE_EMPLOYER_VALUE = 2L;
	public static final Long ROLE_ADMIN_VALUE = 3L;
	
	/**
	 * Anonymous user
	 */
	public static final String ANONYMOUS_USER = "anonymousUser";
	
	/**
	 * Auths in the system
	 */
	public static final String AUTH_ROLE_CANDIDATE_VIEW = "ROLE_CANDIDATE_VIEW";
	public static final String AUTH_ROLE_ADMIN_VIEW = "ROLE_ADMIN_VIEW";
	public static final String AUTH_ROLE_EMPLOYER_VIEW = "ROLE_EMPLOYER_VIEW";
	
	
	/**
	 * Email and social networks related properties
	 */
	public static final String PROPERTY_LI_API_KEY = "liApiKey";
	public static final String PROPERTY_LI_API_SECRET = "liApiSecret";
	public static final String PROPERTY_FB_API_KEY = "fbApiKey";
	public static final String PROPERTY_FB_API_SECRET = "fbApiSecret";
	public static final String PROPERTY_GOOGLE_API_KEY = "googleApiKey";
	public static final String PROPERTY_GOOGLE_API_SECRET = "googleApiSecret";
	public static final String PROPERTY_LIVE_API_KEY = "liveApiKey";
	public static final String PROPERTY_LIVE_API_SECRET = "liveApiSecret";
	public static final String PROPERTY_LIVE_API_REDIRECT = "liveRedirect";
	public static final String PROPERTY_TWITTER_API_KEY = "twitterApiKey";
	public static final String PROPERTY_TWITTER_API_SECRET = "twitterApiSecret";
	public static final String PROPERTY_DROPINS_API_KEY = "dropinskey";
	
	/**
	 * For Checking whether the environment is a test environment or not
	 */
	public static final String PROPERTY_IS_TEST_ENVIRONMENT = "isTestEnvironment";
	/**
	 * Email Ids which will receive mail in the test environment
	 */
	/**
	 * Property for smtp server
	 */
	public static final String SMTP = "smtp";
	
	
	/**
	 * Parameters of the job url when user is coming to site
	 */
	public static final String PARAM_DL = "dl";
	
	
	/**
	 * Data Sources
	 */
	public static final String DATA_SOURCE_FB = "FB";
	public static final String DATA_SOURCE_LI = "LI";
	public static final String DATA_SOURCE_GMAIL = "GMAIL";
	public static final String DATA_SOURCE_MANUAL = "MANUAL";
	public static final String DATA_SOURCE_JOBBUZZ = "JOBBUZZ";
	public static final String DATA_SOURCE_TJ = "TJ";
	public static final String DATA_SOURCE_TWITTER = "TWITTER";
	public static final String DATA_SOURCE_DRIBBLE = "DRIBBLE";
	public static final String DATA_SOURCE_QORA = "QORA";
	public static final String DATA_SOURCE_GITHUB = "GITHUB";
	
	/**
	 * Network Import status
	 */
	public static final Boolean NETWORK_DATA_NOT_FETCHED = Boolean.FALSE;
	public static final Boolean NETWORK_DATA_FETCHED = Boolean.TRUE;
	
	/**
	 * Ask your network page sizes 
	 */
	public static final int PAGE_SIZE_AYN = 50;
	
	
	/**
	 * FB States 
	 */
	public static final String FBSTATE_ACCOUNT_SETTINGS = "Account_Settings";
	public static final String FBSTATE_WALL_POST_UNSECURE ="FB_WALL_POST_UNSECURE";
	public static final String FBSTATE_RESYNC = "FB_RESYNC";
	
	
	/**
	 * LI States 
	 */
	public static final String LISTATE_ACCOUNT_SETTINGS = "Account_Settings";
	public static final String LISTATE_SHARE_JOB_STEP3 = "SHARE_JOB_STEP3";
	public static final String LISTATE_SHARE_JOB_STEP2 = "SHARE_JOB_STEP2";
	public static final String LISTATE_RESYNC = "LI_REYNC";
	public static final String LISTATE_DASHBOARD_APP_STATUS = "DASHBOARD_APP_STATUS";
	
	/**
	 * Google States 
	 */
	public static final String GOOGLESTATE_RESYNC = "GOOGLE_RESYNC";
	
	/**
	 * Twitter States
	 */
	public static final String TWSTATE_ACCOUNT_SETTINGS = "TW_ACCOUNT_SETTIINGS";
	public static final String TWITTER_TYPE_FOLLOWING = "FOLLOWING";
	public static final String TWITTER_TYPE_FOLLOWER = "FOLLOWER";
	public static final String TWSTATE_RESYNC = "TW_RESYNC";	
	/**
	 * Type of email contacts
	 */
	public static final String CONTACT_TYPE_GMAIL = "GMAIL";
	
	/**
	 * Type of email connection
	 */
	public static final String CONNECTION_TYPE_COLLEGE = "COLLEGE";
	public static final String CONNECTION_TYPE_COMPANY = "COMPANY";
	public static final String CONNECTION_TYPE_FRIEND = "FRIEND";
	
	
	/**
	 * Properties related to email
	 */
	public static final String PROPERTY_SOCIAL_FROM_MAIL = "socialFromMail";
	
	/**
	 * Types of Shares
	 */
	public static final String SHARE_TYPE_FB = "FB";
	public static final String SHARE_TYPE_FB_MESSAGE = "FB_MESSAGE";
	public static final String SHARE_TYPE_LI = "LI";
	public static final String SHARE_TYPE_LI_MESSAGE = "LI_MESSAGE";
	public static final String SHARE_TYPE_TW = "TW";
	public static final String SHARE_TYPE_EMAIL = "EM";
	
	/**
	 * Types of file for Application
	 * Possible values resume, coverLetter
	 */
	public static final String APPLICATION_TYPE_FILE_RESUME = "resume";
	public static final String APPLICATION_TYPE_FILE_COVERLETTER = "coverLetter";
	
    /**
     * Fixed content for fb share on wall
     */
    public static final String FIXED_CONTENT_FOR_FB_SHARE = "JobBuzz is a new way to discover talent using your own trusted network.";
	
    /**
     * Search mailer 
     * */
    
    public static final int BATCH_MAIL_SEARCH_MAX_RESULTS = 1000;
    
 	/**
 	 * constant for gamification reward
 	 */
 	public static final Integer GAMIFICATION_REWARD_TYPE_BADGE_COMMON = 0;
 	public static final Integer GAMIFICATION_REWARD_TYPE_POINT = 1;
 	public static final Integer GAMIFICATION_REWARD_TYPE_BADGE = 2;
 	public static final String GAMIFICATION_REWARD_TYPE_BADGE_NAME = "Badges";
 	
 	/**
 	 * constant for gamification status
 	 */
 	public static final Integer GAMIFICATION_STATUS_TYPE_INACTIVE = 0;
 	public static final Integer GAMIFICATION_STATUS_TYPE_ACTIVE = 1;
 	public static final Integer GAMIFICATION_STATUS_TYPE_DELETED = 2;
 	
 	/**
 	 * Time durations
 	 */
 	public static final Integer TIME_DURATION_HOURLY_CONSTANT = 1;
 	public static final Integer TIME_DURATION_DAILY_CONSTANT = 2;
 	public static final Integer TIME_DURATION_WEEKLY_CONSTANT = 3;
 	public static final Integer TIME_DURATION_MONTHLY_CONSTANT = 4;
 	public static final Integer TIME_DURATION_QUATERLY_CONSTANT = 5;
 	public static final Integer TIME_DURATION_HALF_YEARLY_CONSTANT = 6;
 	public static final Integer TIME_DURATION_YEARLY_CONSTANT = 7;
 	public static final Integer TIME_DURATION_MINUTE_CONSTANT = 8;
 	
 	/**
 	 * Reward Rules
 	 */
 	public static final Integer GAMIFICATION_REWARD_RULE_ALL = 1;
 	public static final Integer GAMIFICATION_REWARD_RULE_ANY_ONE = 2;
 	
 	/**
 	 * Behaviour type
 	 */
 	public static final Integer GAMIFICATION_BEHAVIOUR_TYPE_THE_BEHAVIOUR = 1;
 	public static final Integer GAMIFICATION_BEHAVIOUR_TYPE_ALL_THE_BEHAVIOUR = 2;
 	public static final Integer GAMIFICATION_BEHAVIOUR_TYPE_ANY_BEHAVIOUR = 3;
 	
 	/**
 	 * Rules type
 	 */
 	public static final Integer GAMIFICATION_RULE_TYPE_EXACTLY = 1;
 	public static final Integer GAMIFICATION_RULE_TYPE_MORE_THAN = 2;
 	public static final Integer GAMIFICATION_RULE_TYPE_LESS_THAN = 2;
 	
 	/**
 	 * Schedules Type
 	 */
 	public static final Integer GAMIFICATION_SCHEDULE_TYPE_ON = 1;
 	public static final Integer GAMIFICATION_SCHEDULE_TYPE_BEFORE = 2;
 	public static final Integer GAMIFICATION_SCHEDULE_TYPE_AFTER = 3;
 	
 	
 	/**
 	 * Jobbuzz Urls constants
 	 */
 	
 	public static final String JOBBUZZ_AUTO_LOGIN = "jobbuzzAutoLogin";
 	public static final String JOBBUZZ_UNSUBSCRIBE = "jobbuzzUnsubscribe";
 	
 	/**
 	 * default site configuration for session
 	 */
 	public static final String GAMIFICATION_DEFAULT_SITE_ID_TEXT = "siteId";
 	public static final Long GAMIFICATION_DEFAULT_SITE_ID = 1L;
 	public static final String GAMIFICATION_DEFAULT_SITE = "site";
 	
 	
 	/**
 	 * leader board constants
 	 */
 	
 	public static final Integer GAMIFICATION_LEADER_BOARD_SCOPE_TYPE_GLOBAL = 0;
 	public static final Integer GAMIFICATION_LEADER_BOARD_SCOPE_TYPE_LOCAL = 1;
 	public static final Integer GAMIFICATION_LEADER_BOARD_DISPLAY_TYPE_ABSOLUTE = 1;
 	public static final Integer GAMIFICATION_LEADER_BOARD_DISPLAY_TYPE_RELATIVE = 0;
 	
 	/**
 	 * constants for mission
 	 */
	public static final Boolean GAMIFICATION_MISSION_TYPE_RANDOM = Boolean.TRUE;
	public static final Boolean GAMIFICATION_MISSION_TYPE_PROGRESSION = Boolean.FALSE;
	
	/**
	 * constant for message note and hint lenght
	 */
	
	public static final Integer GAMIFICATION_MAX_MESSAGE_LENGHT = 1000;
	public static final Integer GAMIFICATION_MAX_HINT_LENGHT = 500;
	public static final Integer GAMIFICATION_MAX_NAME_LENGTH = 100;
 	public static final Integer GAMIFICATION_MAX_URL_LENGTH = 255;
 	public static final Integer GAMIFICATION_MAX_NOTE_LENGTH = 5000;
 	public static final Integer GAMIFICATION_MAX_CATAGORY_NAME_LENGTH = 100;
 	public static final long GAMIFICATION_MAX_IMAGE_SIZE = 1028;
 	/**
 	 * gamifiaction behaviour validation constant
 	 */
 	public static final Integer GAMIFICATION_MAX_VERB_LENGTH = 100;
 	
	
	/**
	 * constants for BehaviourRewards View 
	 */
	public static final String FORM_EDIT_TYPE_NEW = "new"; 
	public static final String FORM_EDIT_TYPE_EDIT = "edit"; 
	public static final String FORM_EDIT_TYPE_DELETED = "deleted";
	
	public static final Integer GAMIFICATION_CREATE_MODE = 1;
	public static final Integer GAMIFICATION_COPY_MODE = 2;
	public static final Integer GAMIFICATION_EDIT_MODE = 3;

	/**
 	 * Time durations
 	 */
 	public static final String TIME_DURATION_HOURLY_STRING = "Hours";
 	public static final String TIME_DURATION_DAILY_STRING = "Daily";
 	public static final String TIME_DURATION_WEEKLY_STRING = "Weekly";
 	public static final String TIME_DURATION_MONTHLY_STRING = "Monthly";
 	public static final String TIME_DURATION_QUATERLY_STRING = "Quaterly";
 	public static final String TIME_DURATION_HALF_YEARLY_STRING = "Half Yearly";
 	public static final String TIME_DURATION_YEARLY_STRING = "Yearly";
 	public static final String TIME_DURATION_MINUTE_STRING = "Minute";
	
 	
 	/* validation constants */
 	
 	/**
	 * Stages of the user
	 */
	public static final Integer ACTIVE = 1;
	public static final Integer INACTIVE = 0;
 	
	public static final String SOCIAL_MALE = "male";
	public static final String SOCIAL_FEMALE = "female";
	
	public static final String JOBBUZZ_MALE = "m";
	public static final String JOBBUZZ_FEMALE = "f";
	public static final String SOURCE_TJ = "TJ";
	public static final Integer USER_ACTIVE_STATUS = 1;
	
	/**
	 * Emails notifications type
	 */
	
	public static final Integer EMAIL_NOTIFICATION_ALL = 1;
	public static final Integer EMAIL_NOTIFICATION_ON_INTEREST = 2;
	public static final Integer EMAIL_NOTIFICATION_ACCOUNTS_ONLY = 3;
	
	/**
	 * Email notifications frequency type
	 */
	
	public static final Integer EMAIL_FREQUENCY_EVERY_ACTIVITY = 1;
	public static final Integer EMAIL_FREQUENCY_DAILY_DIGEST = 2;
	public static final Integer EMAIL_FREQUENCY_WEEKLY_DIGEST = 3;
	
	/**
	 * Notification type for notification master 
	 */
	public static final String NTYPE_NOTIFICATION = "NOTIFICATION";
	public static final String NTYPE_EMAIL_FREQUENY = "EMAIL_FREQUENY";
	
	

	
	
	/**
	 * Moderation type
	 */
	public static final Integer MODERATION_FLAG_ACTIVE = 1;
	public static final Integer MODERATION_FLAG_UNDER_MODERATION = 2;
	public static final Integer MODERATION_FLAG_REJECTED = 3;
	public static final Integer MODERATION_FLAG_DELETED = 4;
	public static final Integer MODERATION_FLAG_EXPIRED = 5;
	
	
	
	
	/**
	 * Company Review Questions Card Index Wise
	 */
	public static final String JB_REVIEW_CARD3_LOGIN_QUESTIONS 	= "JB_REVIEW_STEP3_LOGIN_QUESTIONS";
	public static final String JB_REVIEW_CARD3_NON_LOGIN_QUESTIONS 	= "JB_REVIEW_STEP5_NON_LOGIN_QUESTIONS";
	public static final String JB_REVIEW_CARD4_QUESTIONS 	= "JB_REVIEW_STEP4_QUESTIONS";
	public static final String JB_REVIEW_CARD5_QUESTIONS 	= "JB_REVIEW_STEP5_QUESTIONS";
	public static final String JB_REVIEW_CARD6_QUESTIONS 	= "JB_REVIEW_STEP6_QUESTIONS";
	public static final String JB_REVIEW_CARD7_QUESTIONS 	= "JB_REVIEW_STEP7_QUESTIONS";
	public static final String JB_REVIEW_CARD8_QUESTIONS 	= "JB_REVIEW_STEP8_QUESTIONS";
	public static final String JB_REVIEW_CARD9_QUESTIONS 	= "JB_REVIEW_STEP9_QUESTIONS";
	public static final String JB_REVIEW_CARD10_QUESTIONS 	= "JB_REVIEW_STEP10_QUESTIONS";
	public static final Integer JB_REVIEW_SALARY_QUESTION_ID 	= 10;
	
	
	/**
	 * constant for vote type
	 */
	
	public static final Integer JB_VOTE_TYPE_UPVOTE = 1;
	public static final Integer JB_VOTE_TYPE_DOWNVOTE = -1;
	public static final Integer JB_VOTE_TYPE_NOVOTE = 0;
	
	
	/**
	 * Search Index Related
	 */
	public static final String JB_SEARCH_COMMENT_TYPE_IA = "IA";
	public static final String JB_SEARCH_COMMENT_TYPE_IQ = "IQ";
	public static final String JB_SEARCH_REVIEW_TYPE_R = "R";
	
	public static final String JB_SEARCH_SORT_BY_COMPNAY_NAMES= "compnames";
	public static final String JB_SEARCH_SORT_BY_COMPNAY_IDS= "compids";
	public static final String JB_SEARCH_SORT_BY_ROLE_NAMES= "rolenames";
	public static final String JB_SEARCH_SORT_BY_ROLE_IDS= "roleids";
	public static final String JB_SEARCH_SORT_BY_SKILL_NAMES= "skillnames";
	public static final String JB_SEARCH_SORT_BY_SKILL_IDS= "skillids";
	public static final String JB_SEARCH_SORT_BY_MODIFY_TS= "mts";
	public static final String JB_SEARCH_SORT_BY_CREATED_TS= "cts";
	public static final String JB_SEARCH_SORT_BY_POSTED_DATE= "pdate";
	public static final String JB_SEARCH_SORT_BY_INTERVIEW_DATE= "idate";
	
	
	
	public static final String JB_SEARCH_SORT_BY_COMPNAY_NAME_VAL= "company_name";
	public static final String JB_SEARCH_SORT_BY_COMPNAY_ID_VAL= "company_id";
	//public static final String JB_SEARCH_SORT_BY_ROLE_NAME_VAL= "role_name";
	public static final String JB_SEARCH_SORT_BY_ROLE_ID_VAL= "role_id";
	//public static final String JB_SEARCH_SORT_BY_SKILL_NAME_VAL= "skill_name";
	public static final String JB_SEARCH_SORT_BY_SKILL_ID_VAL= "skill_id";
	public static final String JB_SEARCH_SORT_BY_MODIFY_TS_VAL= "modified_ts";
	public static final String JB_SEARCH_SORT_BY_CREATED_TS_VAL= "created_ts";
	public static final String JB_SEARCH_SORT_BY_POSTED_DATE_VAL= "post_date";
	public static final String JB_SEARCH_SORT_BY_INTERVIEW_DATE_VAL= "interview_date";
	
	
	public static final String JB_SEARCH_SORT_TYPE_ASC = "A";
	public static final String JB_SEARCH_SORT_TYPE_DESC = "D";
	public static final String JB_SEARCH_SORT_TYPE_ASC_VAL = "asc";
	public static final String JB_SEARCH_SORT_TYPE_DESC_VAL = "desc";
	
	/**
	 * constant for vote status
	 */
	public static final Integer JB_VOTE_RESPONSE_STATUS_SUCCESS = 1;
	public static final Integer JB_VOTE_RESPONSE_STATUS_FAIL = 0;
	public static final Integer JB_VOTE_RESPONSE_STATUS_UNAUTHORISED = 2;
	public static final Integer JB_VOTE_RESPONSE_STATUS_ALREADY_VOTED = 3;
	public static final Integer JB_VOTE_RESPONSE_STATUS_INVALID_DATA = 4;
	
	/**
	 * constant for vote status messages
	 */
	public static final String JB_VOTE_RESPONSE_MESSAGE_SUCCESS = "voted";
	public static final String JB_VOTE_RESPONSE_MESSAGE_FAIL = "voting fail";
	public static final String JB_VOTE_RESPONSE_MESSAGE_UNAUTHORISED = "user not loged in";
	public static final String JB_VOTE_RESPONSE_MESSAGE_ALREADY_VOTED = "user already voted";
	public static final String JB_VOTE_RESPONSE_MESSAGE_INVALID_DATA = "invalid data";
	
	
	/**
	 * Job change status
	 */
	public static final Integer SELECT = 1;
	public static final Integer LOOKING_OUT_FOR_JOB_CHANGE = 2;
	public static final Integer OPEN_FOR_INTERESTING_CAREER = 3;
	public static final Integer OK_WITH_CURRENT_JOB  = 4;
	
	/**
	 * Job change status
	 */
	public static final String SELECT_TEXT  = "Select";
	public static final String LOOKING_OUT_FOR_JOB_CHANGE_TEXT = "I Am looking out for a job Change";
	public static final String OPEN_FOR_INTERESTING_CAREER_TEXT = "I am open for interesting career options";
	public static final String OK_WITH_CURRENT_JOB_TEXT  = "I am ok with my current job (not looking for change)";
	
	public static final String LOOKING_OUT_FOR_JOB_CHANGE_DISPLAY = "Looking out";
	public static final String OPEN_FOR_INTERESTING_CAREER_DISPLAY = "Open for Opportunities";
	public static final String OK_WITH_CURRENT_JOB_DISPLAY  = "Not looking out for change";
	
	/**
	 * visibility constants
	 */
	
	public static final Integer VISIBLE = 1;
	public static final Integer INVISIBLE = 0;
	
	
	
	public static final String PROS = "p";
	public static final String CONS = "C";
	
	
	/**
	 * FOLLOW A COMPANY OR NOT CONSTRAINTS
	 */
	public static final String FOLLOW_COMPANY_YES = "1";
	public static final String FOLLOW_COMPANY_NO = "0";
	public static final String DREAM_COMPANY = "dream_company";
	
	
	public static final int SOLD_COMPANY_STATUS_NOT_VISIBLE = 0;
	public static final int SOLD_COMPANY_STATUS_VISIBLE = 1;
	
	public static final int SOLD_COMPANY_IS_DELETED_YES = 0;
	public static final int SOLD_COMPANY_IS_DELETED_NO = 1;
	
	public static final String fbPublicUrl = "https://www.facebook.com/";
	public static final String liPublicUrl = "https://www.linkedin.com/";
	
	
	/**
	 * constant for interview and interview question and answer
	 * 
	 */
	
	public static final String OBJECT_TYPE_INTERVIEW = "I";
	public static final String COMMENT_TYPE_INTERVIEW_QUESTION = "IQ";
	public static final String COMMENT_TYPE_INTERVIEW_ANSWER = "IA";
	
	/**
	 * module types
	 */
	public static final String MODULE_TYPE_INTERVIEW = "I";
	public static final String MODULE_TYPE_REVIEW = "R";
	public static final String MODULE_TYPE_INTERVIEW_COMMENT = "IC";
	
	
	/**
	 * Company Page Size 
	 */
	public static final int COMPANY_JOB_PAGE_SIZE = 3;
	public static final int COMPANY_CARD_LIST_SIZE = 20;
	
	/**
	 * Gplus organization types
	 */
	public static final String GPLUSSCHOOLTYPE = "school";
	public static final String GPLUSWORKTYPE = "work";
	
	/**
	 * pro con type 
	 */
	public static final String JBREVIEW_TYPE_PRO = "P";
	public static final String JBREVIEW_TYPE_CON = "C";
	
	/**
	 * rating mas mapping
	 */
	public static final Long COMPANY_RATING_TYPE_SALARY_ID = 1L;
	public static final Long COMPANY_RATING_TYPE_WORK_LIFE_BALANCE_ID = 2L;
	public static final Long COMPANY_RATING_TYPE_COMPANY_CULTURE_ID = 3L;
	public static final Long COMPANY_RATING_TYPE_CAREER_GROWTH_ID = 4L;
	
	/**
	 * SOCIAL SITES URL CODE
	 */
	public static final Integer SOCIAL_URL_TWITTER_CODE= 1;
	public static final Integer SOCIAL_URL_FACEBOOK_CODE= 2;
	public static final Integer SOCIAL_URL_RSS_FEED_CODE= 3;
	public static final Integer SOCIAL_URL_BLOGURL_CODE= 4;
	public static final Integer SOCIAL_URL_POLL_CODE= 5;
	public static final Integer SOCIAL_URL_BANNER_TARGET_CODE= 6;
	public static final Integer SOCIAL_URL_VIDEO_CODE= 7;
	public static final Integer SOCIAL_URL_PICASA_PHOTO_CODE= 8;
	public static final Integer SOCIAL_URL_GOOGLE_PLUS_CODE= 9;
	public static final Integer SOCIAL_URL_LINKEDIN_CODE=10;
	
	
	
	
	
	/*
	 * JB SEARCH TYPES CODE
	 */
	public static final String JB_SEARCH_BY_DEFAULT_TO_JOB = "-1";
	public static final String JB_SEARCH_BY_INTERVIEW = "1";
	public static final String JB_SEARCH_BY_COMPANY = "2";
	public static final String JB_SEARCH_BY_JOB = "3";
	public static final String JB_SEARCH_BY_PEOPLE = "4";
	public static final String JB_SEARCH_BY_NEWS = "5";
	public static final String JB_SEARCH_BY_CAREER_INSIGHT = "6";
	
	

	
	/**
	 * JB COMPANY REVIEW RATING
	 */
	public static final Integer JB_RATING_SALARY = 1;
	public static final Integer JB_RATING_WORK_LIFE_BAL = 2;
	public static final Integer JB_COMPANY_CULTURE = 3;
	public static final Integer JB_CAREER_GROWTH = 4;
	
	
	
	
	/*
	 *	JB IMAGES CONSTANT 
	 */
	public static final Integer JOBBUZZ_LOGO_IMAGE= 1;
	public static final Integer JOBBUZZ_BANNER_IMAGE= 2;
	public static final Integer JOBBUZZ_BACKGROUND_IMAGE= 3;
	public static final Integer JOBBUZZ_COMPANY_IMAGE= 4;
	
	
	/**
	 * JB defaults dates
	 */
	public static final Integer JB_DEFAULT_START_MONTH = 00;
	public static final Integer JB_DEFAULT_END_MONTH = 11;
	public static final Integer JB_DEFAULT_START_DAY = 01;
	public static final Integer JB_DEFAULT_END_DAY = 28;
	
	/**
	 * constants for count service
	 */
	public static final String COUNT_TYPE_VIEW = "view";
	public static final String COUNT_TYPE_SHARE = "share";
	public static final String COUNT_TYPE_UP_VOTE = "upvote";
	
	/**
	 * Constants for employer type 
	 */
	public static final String EMPLOYER_TYPE_CURRENT = "C";
	public static final String EMPLOYER_TYPE_FORMER = "F";
	public static final String EMPLOYER_TYPE_UNKNOWN = "U";
	
	/**
	 * Texts for employee type
	 */
	public static final String EMPLOYEE_TYPE_CURRENT_TEXT = "current";
	public static final String EMPLOYEE_TYPE_FORMER_TEXT = "former";
	public static final String EMPLOYEE_TYPE_UNKNOWN_TEXT = "an";
	
	/**
	 * status constant
	 */
	public static final Integer STATUS_TYPE_NONE = 0;
	public static final Integer STATUS_TYPE_ACTIVE = 1;
	public static final Integer STATUS_TYPE_UNDER_MODERATION = 2;
	public static final Integer STATUS_TYPE_REJECTED = 3;
	public static final Integer STATUS_TYPE_DELETED = 4;
	public static final Integer STATUS_TYPE_EXPIRED = 5;

	public static final Long COMPANY_VARIANT_MIN_ID = 6000000L;
	
	
	/*
	 * MEDIA TYPE FOR COMPANY PHOTO AND VIDEO
	 */
	public static final Integer JB_MEDIA_TYPE_PHOTO = 0;
	public static final Integer JB_MEDIA_TYPE_VIDEO = 1;
	
	
	/*
	 * JB COMPANY COMPETITOR ACTIVE AND UN-ACTIVE STATUS
	 */
	public static final String JB_COMPETITOR_ACTIVE = "Y";
	public static final String JB_COMPETITOR_UN_ACTIVE = "N";
	
	
	/*
	 * JB COUNTER UPDATE INTERVAL IN HOUR
	 */
	public static final int JB_COUNTER_REFRESH_HOUR_INTERVAL = 2;
	
	
	/*
	 *  JB TOP COMPANIES NO LIMIT
	 */
	public static final int JB_TOP_COMPANY_COUNT_LIMIT = 50;
	public static final int JB_TOP_COMPANY_REVIEW_COUNT_LIMIT = 50;
	public static final int JB_TOP_COMPANY_REFRESH_HOUR_INTERVAL = 2;
	
	/**
	 * jobbuzz  previous url for storing in session
	 */
	public static final String JOBBUZZ_PREVIOUS_URL = "PREVIOUS_URL";
	
	
	/*
	 * No of Companies to show in Company-Card interview and review page.
	 */
	public static final int JOBBUZZ_COMPANY_CARD_MAX_COMPANY_NO = 6;
	
	
	/**
	 *  INSIGHT TAG TYPES
	 */
	public static final String INSIGHT_TAG_ROLE_TYPE = "roleId";
	public static final String INSIGHT_TAG_SKILL_TYPE = "skillId";
	public static final String INSIGHT_TAG_INDUSTRY_TYPE = "indId";
	public static final String INSIGHT_TAG_COMPANY_TYPE = "compId";
	public static final String INSIGHT_TAG_SPL_INSIGHT_TYPE = "SplTagId";
	
	/**
	 *  INSIGHT NEWS TEXT LENGTH
	 */
	public	static final int INSIGHT_NEWS_CARD_TEXT_LENGTH = 250;
	
	public static final String SEARCH_REFERER = "searchReferer";
	
	
}

