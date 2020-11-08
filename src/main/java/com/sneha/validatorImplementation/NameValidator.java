package com.sneha.validatorImplementation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sneha.validatorInterface.Name;

public class NameValidator implements ConstraintValidator<Name, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
		Matcher m = p.matcher(value);

		if(m.find())
			return false;

		else
			return true;

	}

}
