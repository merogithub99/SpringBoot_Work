package com.texas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	

}
