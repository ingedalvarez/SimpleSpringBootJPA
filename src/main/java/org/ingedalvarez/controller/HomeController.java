package org.ingedalvarez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("showEmployee")
	public ModelAndView showEmployee(@RequestParam int id) {
				
		ModelAndView mv = new ModelAndView("showEmployee");
		return mv;
	}
}
