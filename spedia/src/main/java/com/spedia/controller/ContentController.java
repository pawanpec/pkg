/**
 * 
 */
package com.spedia.controller;

import java.util.HashMap;
import java.util.List;
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
import com.spedia.dao.IReviewsDAO;
import com.spedia.dao.MongoDao;
import com.spedia.model.Reviews;

/**
 * @author pawan
 *
 */
@Controller
public class ContentController {
	
	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;
	@Autowired
	@Qualifier("reviewsDAO")
	private IReviewsDAO reviewsDAO;
	@RequestMapping(value = { "/website.html" }, method = { RequestMethod.GET })
	public ModelAndView schoolDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model=new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("schoolHome");
		String url="website/bal-bharti-pub-school-sector-14-rohini-delhi";
		DBObject content=mongoDao.getContentByURL(url);
		Integer nid=(Integer) content.get("nid");
		List<Reviews> reviews=reviewsDAO.findByNid(nid, 10);
    	model.put("content", content);
    	model.put("reviews", reviews);
    	view.addAllObjects(model);
		return view;
		
	}
	@RequestMapping(value = { "/content.html" }, method = { RequestMethod.GET })
	public ModelAndView contentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model=new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("news");
		String url="nursery-admission-news/admission-notice-pre-nursery-session-2015-16";
		DBObject content=mongoDao.getContentByURL(url);
		Integer nid=(Integer) content.get("nid");
    	model.put("content", content);
    	view.addAllObjects(model);
		return view;
		
	}

}
