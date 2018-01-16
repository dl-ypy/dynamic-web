package com.ypy.struts2.user;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private int type;
	private String r;//保存结果集，要有set,get方法
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}
	
	@Override
	public String execute() throws Exception{
		if (type == 1) r = "/user_success.jsp";
		else if (type == 2) r = "/user_error.jsp";
		return "success";
	}
}
