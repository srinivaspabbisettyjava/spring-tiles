package com.bellinf.batch4.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping(value="/student-login", method=RequestMethod.GET)
	public String studentloginpage(Model model){
		return "student-login";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String tiles(Model model){
		return "home";
		
	}
	
	@RequestMapping(value="/coursesoffered", method=RequestMethod.GET)
	public String coursesOffered(Model model){
		return "coursesoffered";
		
	}
	
	@RequestMapping(value="/contactus", method=RequestMethod.GET)
	public String contactus(Model model){
		return "contactus";
		
	}

}
