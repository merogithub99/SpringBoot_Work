package com.texas.demo.service;

import java.util.List;

import com.texas.demo.model.Department;

public interface DepartmentService {
	void addDepartment(Department dept);
	void deleteDepartment(int id);
	void UpdateDepartment(Department dept);
	Department getDepartmentById(int id);
	List<Department> getAllDepartment();

}
