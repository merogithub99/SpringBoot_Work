package com.texas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String postDepartment(@ModelAttribute Department dept, Model model) {

		deptService.addDepartment(dept);
		model.addAttribute("message", "Department successfully added!!");

		return "DepartmentForm";

	}

	@GetMapping("/departmentList")
	public String getDeptList(Model model) {

		model.addAttribute("dList", deptService.getAllDepartment());
		return "DepartmentListForm";
	}

	@GetMapping("/dept/delete")
	public String deleteDepartment(@RequestParam int id ) {
		
		deptService.deleteDepartment(id);

		return "redirect:/departmentList";
	}
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id,Model model) {
		
		model.addAttribute("dptModel",deptService.getDepartmentById(id));
		return "DepartmentEditForm";
	}
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.UpdateDepartment(dept);
		return "redirect:/departmentList";
	}

}
