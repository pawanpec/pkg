package com.spedia.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.spedia.model.Connection;
import com.spedia.model.Profile;




public interface MongoDao {
	public String saveProfile(Profile profile) ;
	public void saveConnections(Profile profile, List<Connection> connections);
	DBObject getContentByURL(String url);
	DBObject getContentByNid(Integer nid);
	DBCursor getContent(BasicDBObject basicDBObject);
	public DB getMongoDatabase();
}
