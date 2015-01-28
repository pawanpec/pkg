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
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.apache.lucene.util.Version;

public class AutoSuggestService {
	private static IndexSearcher searcher;
	private static String INDEX_PATH = "/opt/indexes/spedia/auto";

	public AutoSuggestService() {
	}

	public static Analyzer getAnalyzer() {
		return  new StandardAnalyzer(Version.LUCENE_4_10_3);
	}

	public static Set<Document> getDocument(Map<String,String> query, int hitCount) throws IOException {
		IndexReader reader = DirectoryReader.open(FSDirectory
				.open(new File(INDEX_PATH)));
		searcher = new IndexSearcher(reader);
		QueryBuilder queryBuilder = new QueryBuilder(getAnalyzer());
		String term =query.get("title");
		term = parseQueryString(term);
		Query q = queryBuilder.createPhraseQuery("title", term);
		System.out.println(q.toString());
		Set<Document> result = new LinkedHashSet<Document>();
		TopScoreDocCollector collector = TopScoreDocCollector.create(hitCount,
				true);
		try {
			searcher.search(q, collector);
			ScoreDoc[] hits = collector.topDocs().scoreDocs;
			System.out.println("Found " + hits.length + " hits.");
			for (int i = 0; i < hits.length; ++i) {
				int docId = hits[i].doc;
				Document d = searcher.doc(docId);
				result.add(d);
				System.out.println((i + 1) + ". " + "\t" + d.get("title"));
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
		Set<Document> d = null;
		Map<String,String> query=new HashMap<String,String>();
		try {
			query.put("title", "bal");
			query.put("city", "rohini");
			query.put("state", "delhi");
			d = getDocument(query, hitCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
