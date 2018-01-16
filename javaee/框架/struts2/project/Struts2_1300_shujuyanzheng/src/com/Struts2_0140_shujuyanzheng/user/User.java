package com.Struts2_0140_shujuyanzheng.user;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
	private String name;
	
	public String add()
	{
		if (name==null || !name.equals("ypy"))//匹配条件
		{
			this.addFieldError("name", "name is error");//添加校验错误信息
			return ERROR;
		}
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
