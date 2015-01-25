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

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
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
		String url=request.getParameter("url");
		//String url="website/bal-bharti-pub-school-sector-14-rohini-delhi";
		DBObject content=mongoDao.getContentByURL(url);
		Integer nid=(Integer) content.get("nid");
		List<Reviews> reviews=reviewsDAO.findByNid(nid, 10);
		BasicDBObject basicDBObject=new BasicDBObject("field_group.target_id", nid);
		DBCursor news=mongoDao.getContent(basicDBObject);
    	model.put("content", content);
    	model.put("reviews", reviews);
    	model.put("news", news);
    	view.addAllObjects(model);
		return view;
		
	}
	@RequestMapping(value = { "/content.html" }, method = { RequestMethod.GET })
	public ModelAndView contentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model=new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("news");
		String url=request.getParameter("url");
		//String url="nursery-admission/heritage-school-vasant-kunj-nursery-admission-schedule-and-criteria-session-2013";
		DBObject content=mongoDao.getContentByURL(url);
		DBObject field_group=(DBObject) content.get("field_group");
		if(field_group!=null){
			Integer groupId=(Integer) field_group.get("target_id");
			if(groupId!=null){
				DBObject group=mongoDao.getContentByNid(groupId);
				model.put("group", group);
			}
		}
    	model.put("content", content);
    	view.addAllObjects(model);
		return view;
		
	}

}
