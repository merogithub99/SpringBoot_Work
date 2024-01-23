package com.texas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
