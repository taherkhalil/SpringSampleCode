package com.taher.springasg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class LoginBean {
	@NotNull(message="Null Email!!!")
	@Email(message="Invalid email address entered!!!")
	private String email;

	@NotNull(message="Null Password!!!")
	@Size(min = 4, max = 15, message="Invalid length of password!!!")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
