package com.ypy.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ypy.struts2.model.LoginModel;

public class Login2Action extends ActionSupport{
	private LoginModel login = new LoginModel();
	
	public LoginModel getLogin() {
		return login;
	}

	public void setLogin(LoginModel login) {
		this.login = login;
	}

	public String login() {
		System.out.println(login);
		return SUCCESS;
	}
	
}
