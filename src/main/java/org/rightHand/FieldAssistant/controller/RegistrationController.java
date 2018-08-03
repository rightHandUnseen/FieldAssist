package org.rightHand.FieldAssistant.controller;

import javax.validation.Valid;

import org.rightHand.FieldAssistant.dto.UserDTO;
import org.rightHand.FieldAssistant.model.User;
import org.rightHand.FieldAssistant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService service;
	
	
	
	@RequestMapping(value = {"/processRegistration"}, method=RequestMethod.POST)
	public String createUser(Model model, @ModelAttribute("userDto") @Valid UserDTO user, BindingResult result) {
		if(result.hasErrors()) {
			return "";
		}else {
			User newUser = new User(user.getUsername(), user.getPassword(), user.getEmail());
			newUser = service.save(newUser);
			model.addAttribute("username", newUser.getUsername());
			model.addAttribute("password", newUser.getPassword());
			return "redirect:/login";
			
			
		}
	}
	
}
