package com.texas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUnameAndPassword(String un,String psw);
	User findByUname(String un);
	
}
