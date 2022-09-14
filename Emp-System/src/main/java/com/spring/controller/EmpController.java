package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.Employee;
import com.spring.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;

	  @GetMapping("/")
	  public String home(Model m)
	  
	  {
		  List<Employee> emp=service.getAllEmp();
		  m.addAttribute("emp",emp);
      return "index";
	  }
	  @GetMapping("/addemp")
	  public String addEmpForm()
	  {
		  return "add_emp";
	  }
	  
	  @PostMapping("/register")
	  public String empRegister(@ModelAttribute Employee e,HttpSession session)
	  {
		  System.out.println(e);
		  session.setAttribute("msg","Employee Added Successfully..");
		  service.addEmp(e);
		  return"redirect:/";
		  
		  
	  }
}
