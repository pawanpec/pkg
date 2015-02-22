package com.spedia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spedia.model.Reviews;
import com.spedia.service.review.IReviewService;

/*Pawan */
@Controller
public class ReviewController {
	@Autowired
	private IReviewService reviewService;
	@RequestMapping(value="/get_all_unmoderated_review.html")
	public ModelAndView reviewModerat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model=new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("review_moderation");
		List<Reviews> reviews=reviewService.getAllUnModeratedReviews();
    	model.put("reviews", reviews);
    	view.addAllObjects(model);
		return view;
		
	}
	@RequestMapping(value="/approveReview.html")
	public Reviews approveReview(HttpServletRequest request, HttpServletResponse response) {
		Integer rid=Integer.parseInt(request.getParameter("rid"));
		Reviews reviews=reviewService.approveReview(rid);
		return reviews;
		
	}
	@RequestMapping(value="/rejectReview.html")
	public Reviews rejectReview(HttpServletRequest request, HttpServletResponse response) {
		Integer rid=Integer.parseInt(request.getParameter("rid"));
		Reviews reviews=reviewService.rejectReview(rid);
		return reviews;
		
	}
	@RequestMapping(value="/writeReview.html")
	public ModelAndView writeReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("writeReview","reviews", new Reviews());
		return view;
		
	}
	@RequestMapping(value = "/submitReview.html")
    public ModelAndView submit(@ModelAttribute("Reviews") Reviews reviews,BindingResult result) {
    	ModelAndView view = new ModelAndView("writeReview");
    	reviewService.writeReview(reviews);
    	 if (result.hasErrors()) {
    	        return view;
    	 }
		return view;
    }

}
