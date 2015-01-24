package com.spedia.content.dao;

import com.mongodb.DBObject;




public interface MongoDao {
	
	DBObject getContentByURL(String url);
	
}
