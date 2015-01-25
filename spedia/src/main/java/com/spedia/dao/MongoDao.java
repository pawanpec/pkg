package com.spedia.dao;

import com.mongodb.DB;
import com.mongodb.DBObject;




public interface MongoDao {
	
	DBObject getContentByURL(String url);
	public DB getMongoDatabase();
}
