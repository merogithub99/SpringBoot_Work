package com.texas.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Indexcontroller {

	@GetMapping("/justfortest")
	public String getIndex() {
		return "index";
	}
}
