package com.spedia.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.spedia.model.Connection;
import com.spedia.model.Profile;
import com.spedia.model.User;




public interface MongoDao {
	public String saveProfile(Profile profile) ;
	public DBObject getUserProfileByProfileID(String profileId, String apc);
	public DBObject getConnection(String pid) ;
	public void saveConnections(Profile profile, List<Connection> connections);
	DBObject getContentByURL(String url);
	DBObject getContentByNid(Integer nid);
	DBCursor getContent(BasicDBObject basicDBObject);
	public WriteResult updateOverAllRating(DBObject review) ;
	public DB getMongoDatabase();
	public DB getMongoDatabase(String dbName) ;
	public WriteResult follow(Integer nid,User user,Boolean status) ;
	public WriteResult saveUserFbData(String jsonData) ;
}
