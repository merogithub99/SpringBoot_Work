package com.texas.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	@RequestMapping(path="processform",method=RequestMethod.POST)
	public String formHandler(
			@RequestParam("uname") String uname,
			@RequestParam("email") String email,
			@RequestParam("pass") String pass,Model model) {
		System.out.println("user email:"+email);
		System.out.println("user name:"+uname);
		System.out.println("user name:"+uname);
		
		
		return "success";
	}

}
