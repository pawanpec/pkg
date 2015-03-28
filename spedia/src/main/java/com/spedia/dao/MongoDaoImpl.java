package com.spedia.dao;

import static com.spedia.utils.MongoConstants.FIELDS_CURRENT_NODE;
import static com.spedia.utils.MongoConstants.MONGO_DB_NAME;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import com.spedia.model.Connection;
import com.spedia.model.Profile;
import com.spedia.model.SchoolBean;
import com.spedia.model.User;
import com.spedia.utils.Constants;
import com.spedia.utils.MongoConstants;
import com.spedia.utils.SocialUtility;

public class MongoDaoImpl implements MongoDao {
	/**
	 * This will be called when the bean will get initialised, this will ensure
	 * that the index on the fields are properly created
	 */
	public void init() {
		System.out.println("ensureIndex called ");
	//	ensureIndex();
	}

	private Mongo mongo;
	public DB getMongoDatabase() {
		return mongo.getDB(MONGO_DB_NAME);
	}
	public DB getMongoDatabase(String dbName) {
		return mongo.getDB(dbName);
	}
	@Override
	public DBObject getContentByURL(String url) {
		DBCollection node = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		DBObject query=new BasicDBObject("alias", url);
		DBObject content=node.findOne(query);
		if(content==null){
			query= new BasicDBObject("url", url); 
			content=node.findOne(query);
		}
		
		return content;
	}
	public Mongo getMongo() {
		return mongo;
	}
	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}
	@Override
	public DBObject getContentByNid(Integer nid) {
		DBCollection node = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		DBObject cond = new BasicDBObject();
		cond.put("_id", nid);
		return node.findOne(cond);
	}
	@Override
	public DBCursor getContent(DBObject basicDBObject) {
		DBCollection node = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		DBObject orderBy=new BasicDBObject("changed",-1);
		return node.find(basicDBObject).sort(orderBy);
	}
	@Override
	public List<DBObject> getTopReviewedSchool() {
		DBCollection node = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		DBObject cond = new BasicDBObject();
		cond.put("type", "group");
		cond.put("review.count", new BasicDBObject("$gt",2));
		DBObject orderBy=new BasicDBObject("review.count",-1);
		DBCursor cursor=node.find(cond).sort(orderBy).limit(4);
		return cursor.toArray();
		
	}
	@Override
	public String saveProfile(Profile profile) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_USER_PROFILE_COLLECTION);
		DBObject cond = new BasicDBObject();
		cond.put(MongoConstants.MONGO_COLLECTION_PROFILEID, profile.getPid());
		cond.put(MongoConstants.MONGO_COLLECTION_APP_CODE, profile.getApc());
		boolean isDataExist = true;
		/**
		 * check if the profile data with the apc exist or not, if exist then
		 * update else insert | we need to have different record for different
		 * apc
		 * 
		 * apc - app-code (tj-timesjobs/jbz-jobbuzz/mbl-mobile etc.)
		 **/
		DBObject o = getUserProfileByProfileID(profile.getPid(),
				profile.getApc());
		if (o == null) {
			/** user data does not exist */
			isDataExist = false;
			o = new BasicDBObject();
		}

		DBObject dataObject = SocialUtility.jsontobson(profile.getD());

		if (!SocialUtility.chkNull(profile.getNid()))
			o.put(MongoConstants.MONGO_COLLECTION_PROVIDER, profile.getNid());
		if (!SocialUtility.chkNull(profile.getLid()))
			o.put(MongoConstants.MONGO_COLLECTION_LOGINID, profile.getLid());
		if (dataObject != null)
			o.put(MongoConstants.MONGO_COLLECTION_DATA, dataObject);
		if (!SocialUtility.chkNull(profile.getPid()))
			o.put(MongoConstants.MONGO_COLLECTION_PROFILEID, profile.getPid());
		if (!SocialUtility.chkNull(profile.getAtk()))
			o.put(MongoConstants.MONGO_ACCESS_TOKEN, profile.getAtk());
		if (!SocialUtility.chkNull(profile.getAtks()))
			o.put(MongoConstants.MONGO_ACCESS_TOKEN_SECRET, profile.getAtks());
		if (!SocialUtility.chkNull(profile.getRtk()))
			o.put(MongoConstants.MONGO_REQUEST_TOKEN, profile.getRtk());
		if (!SocialUtility.chkNull(profile.getRtks()))
			o.put(MongoConstants.MONGO_REQUEST_TOKEN_SECRET, profile.getRtks());
		if (!SocialUtility.chkNull(profile.getSt()))
			o.put(MongoConstants.MONGO_COLLECTION_STATUS, profile.getSt());
		if (!SocialUtility.chkNull(profile.getExp()))
			o.put(MongoConstants.MONGO_COLLECTION_EXPIRESON, profile.getExp());

		o.put(MongoConstants.MONGO_COLLECTION_UPDATED_TIMESTAMP,
				System.currentTimeMillis() / 1000);

		if (profile.getNt() != null) {
			o.put(MongoConstants.MONGO_COLLECTION_USER_CONNECTION,
					profile.getNt());
		}

		if (!o.containsField(MongoConstants.MONGO_COLLECTION_TIMESTAMP)) {
			o.put(MongoConstants.MONGO_COLLECTION_TIMESTAMP,
					System.currentTimeMillis() / 1000);
		}

		if (isDataExist) {
			col.update(cond, o, true, false);
		} else {
			//TZ-33403 :: ensuring CS/APC are inserted when a new object comes.
			if (!SocialUtility.chkNull(profile.getCs()))
				o.put(MongoConstants.MONGO_COLLECTION_CALL_SOURCE, profile.getCs());
			if (!SocialUtility.chkNull(profile.getApc()))
				o.put(MongoConstants.MONGO_COLLECTION_APP_CODE, profile.getApc());
			col.save(o);
		}

		return profile.getPid();
	}

	@Override
	/**
	 * With user connection object we are storing the following data (row by
	 * row) 1. parent-profileID (from profile object) 2. parent-login-id (from
	 * profile object) 3. profileID 4. login_id 5. profile-data 6. times-stamp
	 * 7. token 8. expires-on 9. status (1/0) 10. provider
	 */
	public void saveConnections(Profile profile, List<Connection> connections) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_USER_CONNECTION_COLLECTION);
		Iterator<Connection> itr = connections.iterator();

		// Changes by Arpit
		// Add network data in nt tag for user
		List<String> nt = new ArrayList<String>();
		while (itr.hasNext()) {
			Connection connection = (Connection) itr.next();
			String pid = connection.getPid();
			// Add pid to network
			nt.add(pid);
			DBObject cond = new BasicDBObject();
			cond.put(MongoConstants.MONGO_COLLECTION_PROFILEID, pid);

			DBObject o = new BasicDBObject();
			DBObject dataObject = SocialUtility.jsontobson(connection.getD());
			DBObject conn = getConnection(pid);
			/** parent profile id and parent login id (if any) **/
			Set<String> pId = new HashSet<String>();
			if (conn != null) {
				try {
					Object obj = conn
							.get(MongoConstants.MONGO_COLLECTION_PARENT_PROFILEID);
					if (obj != null) {
						BasicDBList ls = new BasicDBList();
						if (obj instanceof String) {
							String ppid = (String) obj;
							pId.add(ppid);
						} else {
							ls = (BasicDBList) obj;
							Iterator itrpid = ls.iterator();
							while (itrpid.hasNext()) {
								pId.add((String) itrpid.next());
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (profile != null && !SocialUtility.chkNull(profile.getPid())) {
				pId.add(profile.getPid());
			}
			/**check if profile data contains the pid information, if yes than add*/
			if(pId != null && pId.size() > 0){
				o.put(MongoConstants.MONGO_COLLECTION_PARENT_PROFILEID, pId);				
			}
			//-------------------------
			/** check in previous record */
			Set<String> plid = new HashSet<String>();
			if (conn != null) {
				try {
					Object obj = conn
							.get(MongoConstants.MONGO_COLLECTION_PARENT_LOGINID);
					if (obj != null) {
						if (obj instanceof String) {
							String ppid = (String) obj;
							plid.add(ppid);
						} else {
							BasicDBList ls = (BasicDBList) obj;
							Iterator itrplid = ls.iterator();
							while (itrplid.hasNext()) {
								plid.add((String) itrplid.next());
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/**check if profile data contains the plid information, if yes than add*/
			if (profile != null && !SocialUtility.chkNull(profile.getLid())) {
				plid.add(profile.getLid());
			}
			if(plid != null && plid.size() > 0){
				o.put(MongoConstants.MONGO_COLLECTION_PARENT_LOGINID, plid);				
			}
			//-------------------------
			Set<String> apc = new HashSet<String>();
			if (conn != null) {
				try {
					Object obj = conn
							.get(MongoConstants.MONGO_COLLECTION_APP_CODE);
					if (obj != null) {
						BasicDBList ls = new BasicDBList();
						if (obj instanceof String) {
							String ppid = (String) obj;
							apc.add(ppid);
						} else {
							Iterator itrapc = ls.iterator();
							while (itrapc.hasNext()) {
								apc.add((String) itrapc.next());
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/**check if profile data contains the apc information, if yes than add*/
			if (profile != null && !SocialUtility.chkNull(profile.getApc())) {
				apc.add(profile.getApc());
			}
			if(apc != null && apc.size() > 0){
				o.put(MongoConstants.MONGO_COLLECTION_APP_CODE, apc);				
			}
			//-------------------------				
			if (profile != null && !SocialUtility.chkNull(profile.getCs()))
				o.put(MongoConstants.MONGO_COLLECTION_CALL_SOURCE,
						profile.getCs());

			/** connection individual data **/
			if (!SocialUtility.chkNull(connection.getNid()))
				o.put(MongoConstants.MONGO_COLLECTION_PROVIDER,
						connection.getNid());
			if (dataObject != null)
				o.put(MongoConstants.MONGO_COLLECTION_DATA, dataObject);
			if (!SocialUtility.chkNull(connection.getPid()))
				o.put(MongoConstants.MONGO_COLLECTION_PROFILEID,
						connection.getPid());
			if (!SocialUtility.chkNull(connection.getSt()))
				o.put(MongoConstants.MONGO_COLLECTION_STATUS,
						connection.getSt());

			if (conn != null) {
				if (conn.containsField(MongoConstants.MONGO_COLLECTION_TIMESTAMP)) {
					o.put(MongoConstants.MONGO_COLLECTION_TIMESTAMP,
							conn.get(MongoConstants.MONGO_COLLECTION_TIMESTAMP));
				} else {
					o.put(MongoConstants.MONGO_COLLECTION_TIMESTAMP,
							System.currentTimeMillis() / 1000);
				}
			} else {
				o.put(MongoConstants.MONGO_COLLECTION_TIMESTAMP,
						System.currentTimeMillis() / 1000);
			}

			o.put(MongoConstants.MONGO_COLLECTION_UPDATED_TIMESTAMP,
					System.currentTimeMillis() / 1000);
			col.update(cond, o, true, false);
		}

		// Also update nt tag in profile db
		// As of now add only for fb app
		if (profile != null
				&& profile.getCs() != null
				&& nt.size() > 0
				&& profile.getCs().equalsIgnoreCase(
						Constants.SOURCE_FACEBOOK_FBAPP)) {

			DBCollection profileCol = getMongoDatabase().getCollection(
					MongoConstants.MONGO_DB_USER_PROFILE_COLLECTION);

			DBObject cond = new BasicDBObject();
			cond.put(MongoConstants.MONGO_COLLECTION_PROFILEID,
					profile.getPid());
			cond.put(MongoConstants.MONGO_COLLECTION_PROVIDER, profile.getNid());
			cond.put(MongoConstants.MONGO_COLLECTION_CALL_SOURCE,
					profile.getCs());

			DBObject updateObject = new BasicDBObject();
			updateObject.put(MongoConstants.MONGO_COLLECTION_USER_CONNECTION,
					nt.toArray());

			updateObject = new BasicDBObject("$set", updateObject);
			profileCol.update(cond, updateObject);
		}
	}
	/** Get user profile by profile id and app-code **/
	@Override
	public DBObject getUserProfileByProfileID(String profileId, String apc) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_USER_PROFILE_COLLECTION);

		DBObject cond = new BasicDBObject();
		cond.put(MongoConstants.MONGO_COLLECTION_PROFILEID, profileId);
		cond.put(MongoConstants.MONGO_COLLECTION_APP_CODE, apc);

		DBObject returnObject = col.findOne(cond);
		return returnObject;
	}
	@Override
	public DBObject getConnection(String pid) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_USER_CONNECTION_COLLECTION);
		DBObject cond = new BasicDBObject();
		cond.put(MongoConstants.MONGO_COLLECTION_PROFILEID, pid);
		DBObject fields = new BasicDBObject();
		fields.put(MongoConstants.MONGO_COLLECTION_PARENT_PROFILEID, true);
		fields.put(MongoConstants.MONGO_COLLECTION_PARENT_LOGINID, true);
		fields.put(MongoConstants.MONGO_COLLECTION_APP_CODE, true);
		fields.put(MongoConstants.MONGO_COLLECTION_TIMESTAMP, true);
		fields.put(MongoConstants.MONGO_COLLECTION_UPDATED_TIMESTAMP, true);

		DBObject returnObject = col.findOne(cond, fields);
		return returnObject;
	}
	@Override
	public WriteResult updateOverAllRating(DBObject node) {
		DBCollection nodeCollection = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		BasicDBObject nodeQuery = new BasicDBObject();
		nodeQuery.put("_id", node.get("_id"));
		WriteResult c = nodeCollection.update(nodeQuery, node);
		return c;
	}
	@Override
	public WriteResult follow(Integer nid,User user,Boolean status) {
		DBCollection nodeCollection = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		BasicDBObject nodeQuery = new BasicDBObject();
		nodeQuery.put("_id", nid);
		BasicDBObject followObject = new BasicDBObject();
		Integer uid = user.getUid();
		if (status) {
			followObject.put("$addToSet", new BasicDBObject("f", uid));
		}else{
			followObject.put("$pull", new BasicDBObject("f", uid));
		}
		return nodeCollection.update(nodeQuery,followObject, true,
				false);
	}
	@Override
	public WriteResult saveUserFbData(String jsonData) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_USER_PROFILE_COLLECTION);
		DBObject dbObject = (DBObject) JSON.parse(jsonData);
		return col.save(dbObject);
	}
	@Override
	public WriteResult saveFBGroupData(String jsonData) {
		DBCollection col = getMongoDatabase().getCollection(
				MongoConstants.MONGO_DB_FB_GROUP_COLLECTION);
		BasicDBObject basicDBObject=new BasicDBObject();
		basicDBObject.put("data", jsonData);
		//Gson gson=new Gson();
		/*Gson gson = new GsonBuilder().registerTypeAdapter(DBObject.class, new InterfaceAdapter<DBObject>()).create();
		DBObject dbObject = gson.fromJson(jsonData, DBObject.class);*/
		
		DBObject dbObject = (DBObject) JSON.parse(jsonData);
		Set<String> keys=dbObject.keySet();
		for (String key : keys) {
			col.save((BasicDBObject)dbObject.get(key));
		}
		return null;
	}
	@Override
	public String updateSchoolInformation(Integer nid, DBObject schoolData) {
		DBCollection nodeCollection = getMongoDatabase().getCollection(
				FIELDS_CURRENT_NODE);
		BasicDBObject nodeQuery = new BasicDBObject();
		nodeQuery.put("_id", 24280);
		WriteResult c = nodeCollection.update(nodeQuery, schoolData);
		return c.toString();
	}
}
