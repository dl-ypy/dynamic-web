package com.ypy.struts2.model;

public class UserModel {
	private String username;

	@Override
	public String toString() {
		return "UserModel [username=" + username + "]";
	}

	public UserModel(String username) {
		super();
		this.username = username;
	}

	public UserModel() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
