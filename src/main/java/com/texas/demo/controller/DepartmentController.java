package com.texas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.texas.demo.model.Department;
import com.texas.demo.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/department")
	public String getDepartment() {
		
		
		return "DepartmentForm";
		
	}
	
	@PostMapping("/postDepartment")
	public String postDepartment(@ModelAttribute Department dept,Model model) {
		
		deptService.addDepartment(dept);
		model.addAttribute("message", "Department successfully added!!");

		return "DepartmentForm";
		
		
	}

}
