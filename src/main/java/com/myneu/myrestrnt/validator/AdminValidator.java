package com.myneu.myrestrnt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.myrestrnt.model.Admin;



public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Admin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		
		
		Admin admin= (Admin)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validate.username", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");

		
		
	}


	
	
	
	
	
}

