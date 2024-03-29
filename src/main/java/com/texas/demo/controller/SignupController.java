
package com.texas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.texas.demo.model.User;
import com.texas.demo.repository.UserRepository;

@Controller
public class SignupController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/signup")
	public String getSignup() {
		return "signup";

	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = userRepo.findByUname(user.getUname());

		userRepo.save(user);
		return "login";
	}
}
