package org.rightHand.FieldAssistant.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.rightHand.FieldAssistant.validator.UniqueEmailValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
	String message() default "{register.emailAlreadyInUse}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
