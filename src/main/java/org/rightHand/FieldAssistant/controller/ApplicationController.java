package org.rightHand.FieldAssistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

	@ResponseBody
	@RequestMapping("/home")
	public String home() {
		return "mhome.html";
	}
	
	
	@RequestMapping("/core/index")
	public String index() {
		return "/core/index.html";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login.html";
	}
	
	
}
