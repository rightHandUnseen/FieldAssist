package org.rightHand.FieldAssistant.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.rightHand.FieldAssistant.dto.UserDTO;
import org.rightHand.FieldAssistant.validator.annotations.Equals;


public class EqualsValidator implements ConstraintValidator<Equals, UserDTO> {

	@Override
    public void initialize(Equals constraint) {
    }
 
    @Override
    public boolean isValid(UserDTO form, ConstraintValidatorContext context) {
        return form.getPassword().equals(form.getRepassword());
    }

}
