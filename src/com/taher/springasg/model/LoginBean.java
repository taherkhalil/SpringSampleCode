package com.taher.springasg.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.sun.istack.internal.NotNull;

public class LoginBean {
	@NotNull
    @Email
    private String email;
 
    @NotNull
    @Size(min = 6, max = 15)
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
