package com.sneha.validatorImplementation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sneha.validatorInterface.FuelType;

public class FuelTypeValidator implements ConstraintValidator<FuelType, String>{

	 List<String> authors = Arrays.asList("PETROL", "DIESEL", "ELECTRIC");

	    @Override
	    public boolean isValid(String value, ConstraintValidatorContext context) {

	        return authors.contains(value);

	    }
}
