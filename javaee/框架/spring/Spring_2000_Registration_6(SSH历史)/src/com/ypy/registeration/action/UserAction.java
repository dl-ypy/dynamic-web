package com.ypy.registeration.action;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;

@Component("user")//���������Ҫ��Struts2�е�actionname��ͬ
@Scope("prototype")//���óɶ�����ÿ����������һ��action,����struts��Action���̰߳�ȫ����
public class UserAction extends ActionSupport{
	private UserManager um;
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

	@Resource(name="userManager")
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
