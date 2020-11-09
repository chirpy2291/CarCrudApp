package com.sneha.validatorInterface;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sneha.validatorImplementation.YearOfManufactureValidator;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = YearOfManufactureValidator.class)
@Documented
public @interface  YearOfManufacture {
	String message() default "Car cannot be more than 15 years Old or greater than current year";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
