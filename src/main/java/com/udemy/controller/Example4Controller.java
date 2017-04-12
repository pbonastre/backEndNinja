package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	public static final String ERROR404_VIEW = "404";
	public static final String ERROR500_VIEW = "500";
	
	@GetMapping("/redirect404")
	public ModelAndView redirect404(){
		ModelAndView mav = new ModelAndView(ERROR404_VIEW);
		return mav;
	}
	
	@GetMapping("/redirect500")
	public ModelAndView redirect500(){
		ModelAndView mav = new ModelAndView(ERROR500_VIEW);
		return mav;
	}

}
