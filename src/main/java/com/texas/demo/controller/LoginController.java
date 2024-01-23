package com.texas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.texas.demo.model.User;
import com.texas.demo.repository.UserRepository;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepo;

	@GetMapping({ "/login", "/" })
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

		User usr = userRepo.findByUnameAndPassword(user.getUname(), user.getPassword());

		if (usr != null) {
			model.addAttribute("uname", user.getUname());
			return "home";
		}

		model.addAttribute("message", "user not found");
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {

		return "login";
	}
}
