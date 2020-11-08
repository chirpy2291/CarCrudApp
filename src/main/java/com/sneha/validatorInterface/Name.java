package com.sneha.validatorInterface;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sneha.validatorImplementation.NameValidator;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface  Name {

String message() default "CarName cannot have special characters and spaces";

Class<?>[] groups() default {};

Class<? extends Payload>[] payload() default {};
}
