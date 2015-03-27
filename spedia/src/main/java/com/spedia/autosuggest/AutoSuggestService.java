package com.spedia.autosuggest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;

import com.spedia.utils.SchoolsConstants;
import com.spedia.utils.SocialUtility;
@Component
public class AutoSuggestService {
	private static IndexSearcher searcher;

	public AutoSuggestService() {
	}

	public static Analyzer getAnalyzer() {
		return  new StandardAnalyzer(Version.LUCENE_4_10_3);
	}

	public static Set<Map> getDocument(Map<String,String> query, int hitCount) throws IOException, ParseException {
		IndexReader reader = DirectoryReader.open(FSDirectory
				.open(new File(SchoolsConstants.INDEX_PATH)));
		searcher = new IndexSearcher(reader);
		QueryBuilder queryBuilder = new QueryBuilder(getAnalyzer());
		BooleanQuery booleanQuery = new BooleanQuery();
		String term =query.get("title");
		Query q1=null;
		if (!SocialUtility.chkNull(term)) {
			term = parseQueryString(term);
			q1 = new QueryParser(Version.LUCENE_CURRENT,"title", getAnalyzer()).parse(term);
			booleanQuery.add(q1, BooleanClause.Occur.MUST);
		}
		String state = query.get("state");
		if (!SocialUtility.chkNull(state)) {
			Query q2 = queryBuilder.createBooleanQuery("province", state);
			booleanQuery.add(q2, BooleanClause.Occur.MUST);
		}
		String city =query.get("city");
		if (!SocialUtility.chkNull(city)) {
			Query q3 = queryBuilder.createBooleanQuery("city", city);
			booleanQuery.add(q3, BooleanClause.Occur.MUST);
		}
		System.out.println(booleanQuery.toString());
		Set<Map> result = new LinkedHashSet<Map>();
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitCount,
				true);
		try {
			searcher.search(booleanQuery, collector);
			ScoreDoc[] hits = collector.topDocs().scoreDocs;
			System.out.println("Found " + hits.length + " hits.");
			for (int i = 0; i < hits.length; ++i) {
				Map schoolMap=new HashMap<String,Object>();
				int docId = hits[i].doc;
				Document d = searcher.doc(docId);
				schoolMap.put("title", d.get("title"));
				schoolMap.put("id", d.get("id"));
				schoolMap.put("province", d.get("province"));
				result.add(schoolMap);
				//System.out.println((i + 1) + ". " + "\t" + d.get("title"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private static String parseQueryString(String term) {
		// Cleanup Query Term
		term = term.trim();
		term = term.replaceAll("[^a-zA-Z0-9&\\s,]", "");// & added 3410
		term = term.replaceAll("^[^a-zA-Z0-9]", "");
		term = term.replaceAll("\\s+", " ");
		term = term.replaceAll(", ", ",");
		term = term.replaceAll(" ,", ",");
		term = term.replaceAll(",+", ",");

		StringBuffer query = new StringBuffer("");
		String[] terms = term.split("[\\s,]");

		for (int i = 0; i < terms.length - 1; i++) {
			query.append(terms[i]).append(" AND ");
		}
		query.append(terms[terms.length - 1]).append("*");
		return query.toString();
	}

	public static void main(String[] args) {
		int hitCount = 10;
		Set<Map> d = null;
		Map<String,String> query=new HashMap<String,String>();
		try {
			query.put("title", "bal");
			query.put("city", "rohini");
			query.put("state", "delhi");
			d = getDocument(query, hitCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
	}

}
