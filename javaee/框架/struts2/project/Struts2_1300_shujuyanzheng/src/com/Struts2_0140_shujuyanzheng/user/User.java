package com.Struts2_0140_shujuyanzheng.user;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
	private String name;
	
	public String add()
	{
		if (name==null || !name.equals("ypy"))//ƥ������
		{
			this.addFieldError("name", "name is error");//���У�������Ϣ
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
