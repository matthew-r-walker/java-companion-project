package com.organization.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.MGL_Task1.model.Review;

@Controller
public class ReviewController {

	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("reviewCreatePage", "command", new Review());
	}
	
	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

}
