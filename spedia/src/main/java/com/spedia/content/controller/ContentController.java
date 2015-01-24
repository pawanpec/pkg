/**
 * 
 */
package com.spedia.content.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DBObject;
import com.spedia.content.dao.MongoDao;

/**
 * @author pawan
 *
 */
@Controller
public class ContentController {
	
	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;
	@RequestMapping(value = { "/website.html" }, method = { RequestMethod.GET })
	public ModelAndView contentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model=new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("schoolHome");
		String url="website/bal-bharti-pub-school-sector-14-rohini-delhi";
		DBObject content=mongoDao.getContentByURL(url);
    	model.put("content", content);
    	view.addAllObjects(model);
		return view;
		
	}

}
