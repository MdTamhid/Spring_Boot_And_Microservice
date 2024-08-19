package com.tm.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.tm.entity.UserEntity;

@Component
public class UserValidetor implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmployeeValidator.supports()");
		return clazz.isAssignableFrom(UserEntity.class);
	}

	@Override
	public void validate(Object model, Errors errors) {
		
		UserEntity emp=(UserEntity)model;
		
		if(emp.getName()==null || emp.getName().equals("") || emp.getName().length()==0) //required rules
			errors.rejectValue("name", "emp.name.required");
		else if(emp.getName().length()<5 || emp.getName().length()>15)
			errors.rejectValue("name", "emp.name.length");
		
	}

}
