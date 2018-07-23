package org.rightHand.FieldAssistant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

	@ResponseBody
	@RequestMapping("/home")
	public String hello() {
		return "Spring hello";
	}
	
	
	@RequestMapping("/")
	public String welcome() {
		return "welcomepage";
	}
	
	
}
