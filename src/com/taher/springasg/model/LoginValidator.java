package com.taher.springasg.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator  implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return LoginBean.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("class : " + obj.getClass());
		//LoginBean login= (LoginBean) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","error.email", "enter username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","error.password", "enter password");
	}

}
