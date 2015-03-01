/**
 * 
 */
package com.spedia.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.lucene.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spedia.autosuggest.AutoSuggestService;
import com.spedia.utils.SocialUtility;


/**
 * @author pawan
 *
 */
@Controller
public class AutoSuggestController extends BaseWSController{
	@Autowired public AutoSuggestService autoSuggestService;
	
	@RequestMapping(value = "/autoSuggestSchools.json", method = RequestMethod.GET)
	public @ResponseBody String autoSuggestCompanies(HttpServletRequest req,HttpSession session) throws Exception {
		Map<String,String> query=new HashMap<String,String>();
		String state=req.getParameter("state");
		String city=req.getParameter("city");
		String term=req.getParameter("term");
		if(!SocialUtility.chkNull(term)){
			query.put("title", term);
		}
		if(!SocialUtility.chkNull(state)){
			query.put("state", state);
		}
		if(!SocialUtility.chkNull(city)){
			query.put("city", city);
		}
		int hitCount=10;
		Set<Map> d =autoSuggestService.getDocument(query, hitCount);
		return convertIntoJson(d);
	}
}
