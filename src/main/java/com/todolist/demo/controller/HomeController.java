package com.todolist.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/presentation")
	@ResponseBody
	public String demo() {
		return "<h1>Spring Boot Course 2022</h1><p>Todo List Simple Application</p>";
	}
}

