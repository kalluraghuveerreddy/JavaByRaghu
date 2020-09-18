package com.javabyraghu.friendsportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@ResponseBody
	@RequestMapping("/hi")
	public String sayHello() {
		return "Hello All Set to Start";
	}
}
