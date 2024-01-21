package com.texas.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.demo.model.Department;
import com.texas.demo.repository.DepartmentRepository;
import com.texas.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void addDepartment(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public void deleteDepartment(int id) {
		deptRepo.deleteById(id);
	}

	@Override
	public void UpdateDepartment(Department dept) {
		deptRepo.save(dept);

	}

	@Override
	public Department getDepartmentById(int id) {
		
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}

}
