package com.sneha.validatorImplementation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sneha.validatorInterface.YearOfManufacture;

public class YearOfManufactureValidator implements ConstraintValidator<YearOfManufacture, Integer>{


	    @Override
	    public boolean isValid(Integer value, ConstraintValidatorContext context) {
	    	 LocalDate currentdate = LocalDate.now();
	         
	         int currentYear = currentdate.getYear();
	        if(currentYear-value>15 || currentYear-value<0)
	        	return false;
	        return true;
	    }
}
