package org.rightHand.FieldAssistant.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.rightHand.FieldAssistant.services.UserService;
import org.rightHand.FieldAssistant.validator.annotations.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private UserService service;

	public UniqueEmailValidator(UserService userRepository) {
        this.service = userRepository;
    }

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && service.findByEmail(email) != null;
	}

	public void initialize(UniqueEmail constraint) {
	}

}
