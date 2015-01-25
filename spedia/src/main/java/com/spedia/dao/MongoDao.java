package com.spedia.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;




public interface MongoDao {
	
	DBObject getContentByURL(String url);
	DBObject getContentByNid(Integer nid);
	DBCursor getContent(BasicDBObject basicDBObject);
	public DB getMongoDatabase();
}
