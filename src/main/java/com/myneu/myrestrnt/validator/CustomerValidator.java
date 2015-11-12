package com.myneu.myrestrnt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.myrestrnt.model.Customer;



public class CustomerValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated smethod stub
		Customer customer = (Customer)target;
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validate.username", "Your Name Is Incorrenct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Your password Is Incorrenct");

		
	
	}

}