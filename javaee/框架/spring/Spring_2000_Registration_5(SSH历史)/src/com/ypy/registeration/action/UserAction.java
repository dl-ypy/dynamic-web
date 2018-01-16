package com.ypy.registeration.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;
import com.ypy.registeration.service.impl.UserManagerImpl;

public class UserAction extends ActionSupport{
	private UserManager um = new UserManagerImpl();
	private String username;
	private String password;
	private String password2;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		if (um.exists(u)) {
			return "fail";
		}
		um.add(u);
		return "success";
	}
}
