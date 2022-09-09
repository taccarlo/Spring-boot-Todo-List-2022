package com.todolist.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class manages the views navigation of the User
 * For this class are needed to add the Starters: [Thymeleaf]
 * <ul>
 * <li>Controller: The Controller manage the views navigation.</li>
 * <li>RequestMapping: Receives in input the page where to navigate.</li>
 * <li>ResponseBody: indicates that the input is directly the html text to render on the view.</li>
 * </ul>
 * 
 * @version 0.0.1
 * @author Carlo Tacchella
 * @since 22/09/07
 */

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

