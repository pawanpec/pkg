package com.spedia.autosuggest;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.omg.CORBA.INTF_REPOS;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SchoolIndex {
	/**
	 * path where index will be created.
	 */
	private static String INDEX_PATH = "/home/pawan/git/pkg/spedia/auto";

	/**
	 * sql Query for fetching company master & variant name.
	 */
	private static String sqlComp = "select A.COMPANY_NAME ,A.COMPANY_ID, B.varient_name from tcadmin.COMPANY_MAST A, TCUSER.company_varient B where B.company_id  =   A.COMPANY_ID";
	/**
	 * will write the documents into the file system.
	 */
	private static IndexWriter writer = null;
	/**
	 * contains the total documents indexed count.
	 */
	private static long sizeCounter = 0;

	public static final String[] ENGLISH_STOP_WORDS = { "a", "an", "and",
			"are", "as", "at", "be", "but", "by", "for", "if", "into", "is",
			"no", "not", "of", "on", "or", "such", "that", "the", "their",
			"then", "there", "these", "they", "this", "to", "was", "will",
			"with" };

	/**
	 * 
	 * @return Analyzer
	 */

	public static Analyzer getAnalyzer() {
		Analyzer analyzer = new StandardAnalyzer();
		return analyzer;
	}

	/**
	 * initializes the Index writers
	 */
	public static void initializeWriter() {
		try {
			FSDirectory dir = FSDirectory.open(new File(INDEX_PATH));
			IndexWriterConfig config = new IndexWriterConfig(
					Version.LUCENE_4_10_3, getAnalyzer());
			writer = new IndexWriter(dir, config);
		} catch (Exception ioe) {
			System.out
					.println("SEVERE EXCEPTION OCCURRED WHILE INITIALIZING INDEX WRITER.............TERMINATING!!!");
			System.exit(1);
		}

	}

	/**
	 * 
	 * @param tokens
	 *            : String [] of values to be indexed.
	 * @throws IOException
	 */
	public static void insertIntoIndex(DBObject dbObject) throws IOException {
		String title = (String) dbObject.get("title");
		System.out.println("indexing "+title);
		Integer id = (Integer) dbObject.get("_id");
		String province = (String) dbObject.get("location.province");
		String city = (String) dbObject.get("location.city");
		String postal_code = (String) dbObject.get("location.postal_code");

		Document doc = new Document();
		if(title!=null){
			doc.add(new StringField("title", title.trim().toLowerCase(), Field.Store.YES));
		}
		doc.add(new IntField("id", id, Field.Store.YES));
		if(province!=null){
			doc.add(new StringField("province", province, Field.Store.YES));
		}else{
			doc.add(new StringField("province", "", Field.Store.YES));
		}
		if (city!=null) {
			doc.add(new StringField("city", city, Field.Store.YES));
		}else{
			doc.add(new StringField("city", "", Field.Store.YES));
		}
		if (postal_code!=null) {
			doc.add(new StringField("postal_code", postal_code, Field.Store.YES));
		}else{
			doc.add(new StringField("postal_code", "", Field.Store.YES));
		}
		doc.add(new StringField("type", "group", Field.Store.YES));

		if (doc != null) {
			writer.addDocument(doc);
			sizeCounter++;
		}

	}

	public static void main(String[] args) {

		try {

			initializeWriter();
			DBCursor dbCursor = MongoApp.getSchool();
			while (dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				insertIntoIndex(dbObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// DO SOMETHING HERE.
		} finally {

		}
		System.out.println("Total Documents Indexed = " + sizeCounter);
		System.out.println("ENDING THE PROCESS......>>>>>>>.");
	}
}
