package com.spedia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DBObject;
import com.spedia.dao.MongoDao;
import com.spedia.utils.WebConstants;

@Controller
public class SearchController {

	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;
	
	@RequestMapping(value = { "search.html" })
	public ModelAndView search(HttpServletRequest req) {
 		ModelAndView view = new ModelAndView();
		String nid = req.getParameter("nid");
		System.out.println(nid);
		DBObject content=mongoDao.getContentByNid(Integer.parseInt(nid));
		String url=(String)content.get("alias");
		String redirectedUrl="redirect:"+WebConstants.APPLICATION_URL+url;
		view.setViewName(redirectedUrl);
		return view;
	}
}
