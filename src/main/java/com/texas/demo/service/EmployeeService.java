package com.texas.demo.service;

import java.util.List;

import com.texas.demo.model.Employee;

public interface EmployeeService {
	void addEmployee(Employee employee);
	void deleteEmployee(Long id);
	void updateEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	List<Employee> employeeList();
	

}
