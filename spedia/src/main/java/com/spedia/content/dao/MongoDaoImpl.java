package com.spedia.content.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDaoImpl implements MongoDao {
	private static final String MONGO_DB_NAME = "drupal";
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
	@Override
	public DBObject getContentByURL(String url) {
		DBCollection node = getMongoDatabase().getCollection(
				"fields_current.node");
		DBObject cond = new BasicDBObject();
		cond.put("alias", url);
		return node.findOne(cond);
	}
	public Mongo getMongo() {
		return mongo;
	}
	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

}
