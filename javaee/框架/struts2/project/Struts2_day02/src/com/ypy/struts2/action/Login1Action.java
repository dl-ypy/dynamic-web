package com.ypy.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class Login1Action extends ActionSupport{
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String login() {
		System.out.println(username+"--------login--------");
		return SUCCESS;
	}
	
}
