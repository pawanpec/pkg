package com.spedia;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;

import junit.framework.TestCase;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.spedia.service.CounterService;

public class MigrateFBData extends TestCase {
	public static final String mongoHost = "127.0.0.1";// for qc
	public static Mongo mongo;
	public static DBCollection node;
	public static DBCollection fb_group;
	public static DB db;
	public static DBCollection fb_group_test;
	static{
		
		try {
			mongo = new Mongo(mongoHost, 27017);
			db = mongo.getDB("spedia");
			node = db.getCollection("fields_current.node");
			fb_group = db.getCollection("fb_group");
			fb_group_test = db.getCollection("fb_group_test");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void testUpdateURL() {
		DBObject q=new BasicDBObject("src","fb");
		DBCursor dbuCursor = node.find(q);
		//DBCursor dbuCursor=getSchool();
		while (dbuCursor.hasNext()) {
			DBObject nodeObject = dbuCursor.next();
			if (nodeObject != null) {
				String title = (String)nodeObject.get("title");
				nodeObject.put("alias", getInsightSEOURL(title));
				DBObject query=new BasicDBObject("_id",nodeObject.get("_id"));
				node.update(query, nodeObject);
			}
		}
	}
	/*public void testMigrateContent() {
		CounterService counterService = (CounterService) BaseSpringTest.getInstance()
				.getBean("counterService");
		DBObject q=new BasicDBObject("_id",ObjectId.massageToObjectId("5538c9bde4b0c3237df85a0e"));
		DBCursor dbuCursor = fb_group.find();
		//DBCursor dbuCursor=getSchool();
		while (dbuCursor.hasNext()) {
			DBObject nodeObject = dbuCursor.next();
				if (nodeObject != null) {
					int nid = counterService.getNextSequence("_id");
					String body_value = (String)nodeObject.get("message");
					String title=body_value;
					if(body_value!=null){
						if(body_value.length()>=100){
							title=body_value.substring(0,100);
						}
						System.out.println("nid=="+nid+" "+body_value);
						BasicDBObject body=new BasicDBObject();
						body.put("value", body_value);
						body.put("summary", body_value);
						nodeObject.put("body", body);
						nodeObject.put("alias", getInsightSEOURL(title));
						nodeObject.put("title", body_value);
						nodeObject.put("type", "forum");
						nodeObject.put("src", "fb");
						nodeObject.put("nid", nid);
						nodeObject.put("_id",nid);
						//WriteResult c = node.save(nodeObject);
					}
				}
		}
	}*/
	public static String getInsightSEOURL(String insightTitle){
		insightTitle=insightTitle.trim();
		insightTitle = insightTitle
				.replaceAll(" ?- ?","-") // remove spaces around hyphens
				.replaceAll("[ ']","-") // turn spaces and quotes into hyphens
				.replaceAll("[^0-9a-zA-Z-]",""); // remove everything not in our allowed char set
		StringBuffer url = new StringBuffer("discussion");
		if (insightTitle != null) {
			url.append("/" + insightTitle.replace(" ", "-").replace("/", "-").toLowerCase().replace("&", "-"));
		}
		String seoURL=url.toString();
		seoURL=seoURL.replace("--", "-");
		System.out.println(seoURL);
		return seoURL;
	}
	
}
