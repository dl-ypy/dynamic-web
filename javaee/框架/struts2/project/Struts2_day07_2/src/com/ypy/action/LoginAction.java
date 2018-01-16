package com.ypy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ypy.model.LoginModel;

public class LoginAction extends ActionSupport implements ModelDriven<LoginModel>{
	private LoginModel login;
	
	public LoginModel getLogin() {
		return login;
	}

	public void setLogin(LoginModel login) {
		this.login = login;
	}
	
	public String login() {
		System.out.println("----------login-----------"+login);
		if ("111".equals(login.getUsername()) && "222".equals(login.getPassword())) {
			ActionContext.getContext().getSession().put("user_login", login);
			return SUCCESS;
		} else {
			this.addActionMessage("用户信息错误!");
			return "login";
		}
	}
	
	@Override
	public LoginModel getModel() {
		return login;
	}

}
