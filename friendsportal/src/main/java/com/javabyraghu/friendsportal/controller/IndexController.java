package com.javabyraghu.friendsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javabyraghu.friendsportal.model.User;
import com.javabyraghu.friendsportal.model.UserDao;

@Controller
public class IndexController {

	@Autowired
	private UserDao userDao;

	@ResponseBody
	@RequestMapping("/hi")
	public String sayHello() {
		return "Hello All Set to Start";
	}

	@RequestMapping("/index")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping("/")
	public String getRegisterPage(@ModelAttribute("user") User user) {
		return "user-register";
	}

	@PostMapping("/user-register-process")
	public String userRegistration(@ModelAttribute("user") User user) {

		if (userDao.signUp(user)) {
			return "redirect:/login";
		}
		return "redirect:/";

	}

	@PostMapping("/user-login-process")
	public String userLoginProcess(@RequestParam("email") String email, @RequestParam("password") String password) {

		User user = userDao.signIn(email, password);
		if (user != null) {
			return "user-detail";
		}
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "user-login";
	}
}
