package com.texas.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.demo.model.Department;
import com.texas.demo.model.Employee;
import com.texas.demo.model.User;
import com.texas.demo.repository.EmployeeRepository;
import com.texas.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmployee(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		empRepo.save(employee);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		 return empRepo.findById(id).get();

	}

	@Override
	public List<Employee> employeeList() {
		return empRepo.findAll();
	}
	

	
}
