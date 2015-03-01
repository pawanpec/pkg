/**
 * 
 */
package com.spedia.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.lucene.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spedia.autosuggest.AutoSuggestService;


/**
 * @author pawan
 *
 */
@Controller
public class AutoSuggestController extends BaseWSController{
	@Autowired public AutoSuggestService autoSuggestService;
	
	@RequestMapping(value = "/autoSuggestSchools.json", method = RequestMethod.GET)
	public @ResponseBody String autoSuggestCompanies(@RequestParam(value = "term") String term,HttpSession session) throws Exception {
		Map<String,String> query=new HashMap<String,String>();
		query.put("title", term);
		query.put("city", "rohini");
		query.put("state", "delhi");
		int hitCount=10;
		Set<Map> d =autoSuggestService.getDocument(query, hitCount);
		return convertIntoJson(d);
	}
}
