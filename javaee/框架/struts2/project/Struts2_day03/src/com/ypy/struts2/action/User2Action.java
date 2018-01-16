package com.ypy.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ypy.struts2.model.UserModel;

public class User2Action extends ActionSupport implements ModelDriven<UserModel>{
	private UserModel user = new UserModel();
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	

	public String login() {
		System.out.println("--------login--------");
		return SUCCESS;
	}

	@Override
	public UserModel getModel() {
		return user;
	}
	
}
