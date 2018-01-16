package com.ypy.struts2.model;

public class LoginModel {
private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "LoginModel [username=" + username + "]";
	}

	public LoginModel(String username) {
		super();
		this.username = username;
	}

	public LoginModel() {
		super();
	}
}
