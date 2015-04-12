package com.spedia.autosuggest;

import java.net.UnknownHostException;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

/**
 * Java MongoDB Example
 * 
 */
public class MongoApp {
	public static final String mongoHost = "127.0.0.1";// for qc
	public static Mongo mongo;
	public static DB db;
	public static DB drupal;
	public static DB sp_dev;
	public static DBCollection node;
	public static DBCollection redirect;
	public static DBCollection location;
	public static DBCollection review;
	public static DBCollection url;
	public static DBCollection taxonomy_term_data;
	public static DBCollection aff_1;
	public static DBCollection node_drupal;
	static{
		
		try {
			mongo = new Mongo(mongoHost, 27017);
			db = mongo.getDB("spedia");
			drupal = mongo.getDB("drupal");
			sp_dev = mongo.getDB("sp_dev_live");
			node = db.getCollection("fields_current.node");
			node_drupal = drupal.getCollection("fields_current.node");
			redirect = db.getCollection("fields_current.redirect");
			location = sp_dev.getCollection("location_nid_table");
			review = sp_dev.getCollection("reviews_count");
			aff_1 = sp_dev.getCollection("aff_1");
			url = sp_dev.getCollection("url_alias");
			taxonomy_term_data = sp_dev.getCollection("taxonomy_term_data");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	// if database doesn't exists, mongoDB will create it

	// public static final String mongoHost="115.112.206.82";//for staging
	// public static final String mongoHost="115.112.206.104";//for live
	public static void main(String[] args) {

		try {
			// connect to mongoDB
		

			// Get collection from MongoDB, database named "mydb"
			// if collection doesn't exists, mongoDB will create it
			// BasicDBObject query=new BasicDBObject("$exists", false);
			// create a document to store attributes
			int i = 0;
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", 2300);
			DBCursor dbuCursor = node.find();
			//DBCursor dbuCursor=getSchool();
			while (dbuCursor.hasNext()) {
				DBObject nodeObject = dbuCursor.next();
					if (nodeObject != null) {
						Integer nid = (Integer) nodeObject.get("_id");
						System.out.println("Nid "+ nid +" "+i++);
							// updateSchoolInfo(nodeObject, nid);--done
							//	updateRedirectURL(nodeObject, nid);--done
							// updateNodeObject(db,node,nodeObject);
							//updateLocation(nodeObject, nid);--done
						     updateReview(nodeObject, nid);
							//updateURL(nodeObject, nid);--done
							//	updateTags(nodeObject, nid);--done
							//updateSchoolSummary(nodeObject, nid);--done
					}

			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBCursor getSchool(){
		BasicDBObject nodeQuery = new BasicDBObject();
		//nodeQuery.put("_id", 24280);
		nodeQuery.put("type", "group");
		DBCursor dbuCursor = node.find(nodeQuery);
		return dbuCursor;
	}
	private static void updateSchoolInfo(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			DBObject dbObject=node_drupal.findOne(nodeQuery);
			Object v = dbObject.get("sd");
			if (v!=null) {
				nodeObject.put("sd", v);
				//System.out.println(text);
				System.out
						.println("---------------------------------------------------");
				node.update(nodeQuery, nodeObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void updateSchoolSummary(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			DBObject body= (DBObject) nodeObject.get("body");
			String text=(String)body.get("value");
			int i=text.indexOf("<table");
			if (i>0) {
				String summary = text.substring(0, i);
				String bodyValue = text.substring(i);
				System.out.println(summary);
				//System.out.println(bodyValue);
				body.put("value", bodyValue);
				body.put("summary", summary);
				nodeObject.put("body", body);
				WriteResult c = node.update(nodeQuery, nodeObject);
				System.out.println(c.getN());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void updateLocation(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			System.out.println("updating nid " + nid);
			DBObject locationObject = location.findOne(nodeQuery);
			nodeObject.put("location", locationObject);
			System.out.println("updating nid " + nid + " with URL"
					+ locationObject);
			WriteResult c = node.update(nodeQuery, nodeObject);
			System.out.println(c.getN());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void updateTags(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			BasicDBList tagsA=new BasicDBList();
			BasicDBList nursery_admission_tags=new BasicDBList();
			BasicDBList tags=(BasicDBList) nodeObject.get("taxonomyextra");
			BasicDBList taxonomy_vocabulary_15=(BasicDBList) nodeObject.get("taxonomy_vocabulary_15");
			BasicDBList career_tags=(BasicDBList) nodeObject.get("taxonomy_vocabulary_11");
			BasicDBList field_nursery_admission_tags=(BasicDBList) nodeObject.get("field_nursery_admission_tags");
			if (field_nursery_admission_tags!=null) {
				for (Object object : field_nursery_admission_tags) {
					DBObject o = (DBObject) object;
					Integer tid = (Integer) o.get("tid");
					BasicDBObject tagQuery = new BasicDBObject();
					tagQuery.put("tid", tid);
					DBObject tag = taxonomy_term_data.findOne(tagQuery);
					if (tag != null) {
						String tagName = (String) tag.get("name");
						if (tagName!=null) {
							nursery_admission_tags.add(tagName.toLowerCase());
						}
					}

				}
			}
			if (tags!=null) {
				for (Object object : tags) {
					DBObject o = (DBObject) object;
					Integer tid = (Integer) o.get("tid");
					BasicDBObject tagQuery = new BasicDBObject();
					tagQuery.put("tid", tid);
					DBObject tag = taxonomy_term_data.findOne(tagQuery);
					if (tag != null) {
						String tagName = (String) tag.get("name");
						if (tagName!=null) {
							tagsA.add(tagName.toLowerCase());
						}
					}

				}
			}
			if (career_tags!=null) {
				for (Object object : career_tags) {
					DBObject o = (DBObject) object;
					Integer tid = (Integer) o.get("tid");
					BasicDBObject tagQuery = new BasicDBObject();
					tagQuery.put("tid", tid);
					DBObject tag = taxonomy_term_data.findOne(tagQuery);
					if (tag != null) {
						String tagName = (String) tag.get("name");
						if (tagName!=null) {
							tagsA.add(tagName.toLowerCase());
						}
					}

				}
			}
			if (taxonomy_vocabulary_15!=null) {
				for (Object object : taxonomy_vocabulary_15) {
					DBObject o = (DBObject) object;
					Integer tid = (Integer) o.get("tid");
					BasicDBObject tagQuery = new BasicDBObject();
					tagQuery.put("tid", tid);
					DBObject tag = taxonomy_term_data.findOne(tagQuery);
					if (tag != null) {
						String tagName = (String) tag.get("name");
						if (tagName!=null) {
							tagsA.add(tagName.toLowerCase());
						}
					}

				}
			}
			System.out.println(tagsA);
			nodeObject.put("tags", tagsA);
			nodeObject.put("nursery_admission_tags", nursery_admission_tags);
			WriteResult c = node.update(nodeQuery, nodeObject);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void updateReview(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			System.out.println("updating nid " + nid);
			DBObject reviewObject = review.findOne(nodeQuery);
			nodeObject.put("review", reviewObject);
			System.out.println("updating nid " + nid + " with URL"
					+ reviewObject);
			WriteResult c = node.update(nodeQuery, nodeObject);
			System.out.println(c.getN());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void updateURL(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			System.out.println("updating nid " + nid);
			BasicDBObject query = new BasicDBObject();
			query.put("source", "node/" + nid);
			DBObject redirectObject = url.findOne(query);
			String url = (String) redirectObject.get("alias");
			nodeObject.put("alias", url);
			System.out.println("updating nid " + nid + " with URL"
					+ url);
			WriteResult c = node.update(nodeQuery, nodeObject);
			System.out.println(c.getN());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void updateRedirectURL(DBObject nodeObject, Integer nid) {
		try {
			BasicDBObject nodeQuery = new BasicDBObject();
			nodeQuery.put("_id", nid);
			System.out.println("updating nid " + nid);
			BasicDBObject query = new BasicDBObject();
			query.put("redirect", "node/" + nid);
			DBObject redirectObject = redirect.findOne(query);
			String url = (String) redirectObject.get("source");
			if (url!=null) {
				nodeObject.put("url", url);
				System.out.println("updating nid " + nid + " with URL " + url);
				WriteResult c = node.update(nodeQuery, nodeObject);
				System.out.println(c.getN());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}