package org.rightHand.FieldAssistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {


	@RequestMapping("/home")
	public String home() {
		return "/home.html";
	}
	
	
	@RequestMapping("/core/index")
	public String index() {
		return "/core/index.html";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
