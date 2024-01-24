package com.texas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.texas.demo.model.Employee;
import com.texas.demo.service.DepartmentService;
import com.texas.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/registerEmployee")
	public String empRegisterPage(Model model) {
		model.addAttribute("dList", deptService.getAllDepartment());

		return "registerEmployee";
	}

	@PostMapping("/employee")
	public String postEmployeeRegistration(@ModelAttribute Employee emp, Model model) {

		empService.addEmployee(emp);
		model.addAttribute("message", "Employee added successfully");
		return "redirect:/registerEmployee";
	}

	@GetMapping("/employeeList")
	public String employeeList(Model model) {
		model.addAttribute("empList", empService.employeeList());
		return "employeeList";
	}

	@GetMapping("emp/delete")
	public String deleteEmployee(@RequestParam Long id) {
		empService.deleteEmployee(id);
		return "redirect:/employeeList";

	}

	@GetMapping("emp/edit")
	public String editEmployee(@RequestParam Long id, Model model) {
		model.addAttribute("empModel",empService.getEmployeeById(id));
		return "employeeEditForm";

	}

	@PostMapping("emp/update")
	public String updateEmployee(@ModelAttribute Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/employeeList";
	}

}
