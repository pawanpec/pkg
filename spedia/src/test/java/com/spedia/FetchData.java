package com.spedia;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.spedia.model.SchoolData;
import com.spedia.utils.SchoolUtil;

/**

 */

/**
@author pawan
 *
 */
public class FetchData {
	public static final String mongoHost = "127.0.0.1";// for qc
	private static Mongo mongoDao;
	private static DBCollection node ;
	private static DBCollection aff ;
	 static Gson gson=new Gson();
	 static{
			try {
				mongoDao = new Mongo(mongoHost, 27017);
				node = mongoDao.getDB("sp_dev").getCollection( "school_data");
				aff = mongoDao.getDB("sp_dev").getCollection( "aff_1");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MongoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	/**
	@param args
	@throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String states[] = {"TAMIL_NADU", "BIHAR","UTTAR_PRADESH","UTTARANCHAL",
				"ORISSA","WEST_BENGAL","JHARKHAND","ASSAM","MANIPUR","MEGHALAYA","NAGALAND","SIKKIM","TRIPURA","ARUNACHAL_PRADESH","PUNJAB","HARYANA","DELHI","MADHYA_PRADESH","CHHATTISGARH","MAHARASTRA","GOA","DADAR","DAMAN","ANDAMAN","KARNATAKA","KERALA"};
		int start_aff_code[] = {1930001,330001,2130114,3530001,1530001,2430001,3430001,230001,1230001,1330001,1430001,1830001,2030002,
				2230904,1630001,530003,2730001,1030001,3330001,1130001,2830001,3030001,3130001,2530001,830001,930001};
		int end_aff_code[] = {1931001,331263,2141561,3531306,1531197,2431189,3431304,231166,1231073,1331035,1410061,1831046,2031039,
				2231101,1631609,532003,2732000,1031500,3331273,1131317,2831010,3031020,3131020,2531030,831255,932000};	
		
		//int countStart=Integer.parseInt(args[0]);
	/*	int i=0;
		 int startId=0;
		  int endId=0;
			for (String state : states) {
				System.out.println(state);
				startId=start_aff_code[i];
				endId=end_aff_code[i];
				System.out.println("Starting with "+state+"----"+startId+"endid---"+endId);
				while(startId<=endId){
					if(i<countStart)
						 break;
					System.out.println("Starting with "+state+"----"+startId);
					fetchContent(startId+"");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					startId=startId+1;
				}
				i++;
			}
		*/
		//fetchContent("2778036");
		//getData("2778036");
	//	String fileName="/cbse_data.html";
	//	String fileName="/aff_code.csv";
	//	fetchData(fileName);
		DBObject field=new BasicDBObject();
		field.put("sd", new BasicDBObject("$exists",false));
		DBCursor dbCursor=aff.find(field);
		for (DBObject dbObject : dbCursor) {
		 Integer field_affiliation_value=(Integer)	dbObject.get("field_affiliation_value");
			fetchContent(field_affiliation_value+"");
		}
		System.out.println(dbCursor.size());
	

	}
	private static void fetchData(String fileName) {
		
		String affCSV=SchoolUtil.readFile(fileName).toString();
	//	System.out.println(affCSV);
		String[] affCodes=affCSV.split(",");
		for (String affCode : affCodes) {
			affCode=affCode.trim();
			SchoolData schoolData=new SchoolData();
			try {
			} catch (RuntimeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(schoolData==null){
				System.out.println("fetching content for"+affCode);
				try {
					fetchContent(affCode);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private static void fetchContent(String affCode) throws MalformedURLException,
			IOException {
		String url="http://cbseaff.nic.in/cbse_aff/schdir_Report/AppViewdir.aspx?affno="+affCode;
		String fileName="/var/www/schoolspedia.com/cbse_data/"+affCode+".txt";
		System.out.println(url);
		
		//String contentHtml=SchoolUtil.readFile(fileName);
			//SchoolUtil.writeFile(affCode, contentHtml);
		    //System.out.println("content"+contentHtml);
			String first_tag ="<table";
			String end_tag ="InfraStructure Details";
			String article_html = null;
			try {
				String contentHtml=SchoolUtil.getContent(url).toString();
				if(contentHtml!=null)
				article_html = SchoolUtil.getDataBetween2StringRegex(first_tag,end_tag,contentHtml);
				if(article_html!=null)
					fetchAndSaveData(contentHtml, first_tag, end_tag, article_html,url);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println(article_html);
			
	}
	private static void getData(String affCode){
		  DBObject o=new BasicDBObject("a",affCode);
		  DBObject data= node.findOne(o);
		  BasicDBObject	 sd1= (BasicDBObject) data.get("sd");
		  System.out.println(sd1);
		  SchoolData schoolBean= gson.fromJson(sd1.toString(),SchoolData.class);
		  System.out.println(schoolBean);
	}
	private static void fetchAndSaveData(String contentHtml, String first_tag,
			String end_tag, String article_html,String url) throws IOException {
	//	System.out.println("article_html");
		article_html=first_tag+article_html+end_tag;
		//System.out.println(article_html);
	//	System.out.println("noHTMLString-----------");
		String article=SchoolUtil.extractText(article_html);
		SchoolData schoolData=SchoolUtil.getData(article);
		if(schoolData==null){
			return;
		}
		schoolData.setSURL(url);
		//System.out.println(schoolData);
		Boolean isSave=false;
		try {
			DBObject ref=new BasicDBObject("field_affiliation_value", Integer.parseInt(schoolData.getAFF_NO()));
			DBObject s=aff.findOne(ref);
			if(s==null){
			 String sd= gson.toJson(schoolData);
			 DBObject dbObject=new BasicDBObject();
			 dbObject.put("a", schoolData.getAFF_NO());
			 dbObject.put("sd", schoolData);
			  node.save(dbObject);
			}else{
				s.put("sd", schoolData);
				aff.update(ref, s);
			}
			 isSave=true;
		} catch (Exception e) {
			isSave=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data saveed for "+schoolData);
	}
	


}
