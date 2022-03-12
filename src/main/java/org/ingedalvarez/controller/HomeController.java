package org.ingedalvarez.controller;

import java.util.ArrayList;
import java.util.List;

import org.ingedalvarez.dao.EmployeeRepository;
import org.ingedalvarez.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("showEmployee")
	public ModelAndView showEmployee(@RequestParam int id) {
		Employee emp = repo.findById(id).orElse(new Employee());		
		ModelAndView mv = new ModelAndView("showEmployee");
		mv.addObject("emp", emp);
		return mv;
	}

	@RequestMapping("showAllEmployees")
	public ModelAndView showAllEmployees() {
		List<Employee> allEmp = new ArrayList<>();
		Iterable<Employee> allEmpIterable = repo.findAll();
		allEmpIterable.forEach(allEmp::add);
		ModelAndView mv = new ModelAndView();
		mv.addObject("allEmp", allEmp);
		mv.setViewName("home");
		
		return mv;
	}
}
