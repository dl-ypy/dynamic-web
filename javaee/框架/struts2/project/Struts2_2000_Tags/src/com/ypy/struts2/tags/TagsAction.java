package com.ypy.struts2.tags;

import com.opensymphony.xwork2.ActionSupport;

public class TagsAction extends ActionSupport{
	private String username;
	private String password;
	
	public TagsAction(){
		
	}
	
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
	
	@Override
	public String execute(){
		this.addFieldError("fielderror.test" ,"wrong");
		return SUCCESS;
	}
}
