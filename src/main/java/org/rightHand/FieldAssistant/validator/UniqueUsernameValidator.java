package org.rightHand.FieldAssistant.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.rightHand.FieldAssistant.services.UserService;
import org.rightHand.FieldAssistant.validator.annotations.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	private UserService service;
	
	public UniqueUsernameValidator(UserService userRepository) {
        this.service = userRepository;
    }
	

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return username != null && service.findByUsername(username)!=null;
	}

	public void initialize(UniqueUsername constraint) {
    }
	
}
