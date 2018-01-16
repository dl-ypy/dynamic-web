package com.ypy.struts2.action;

import com.opensymphony.xwork2.Action;

public class UserAction implements Action{
	public String query() {
		System.out.println("--------query--------");
		return "success";
	}
	
	public String save() {
		System.out.println("--------save--------");
		return "success";
	}

	//找不到对应的result默认返回的
	@Override
	public String execute() throws Exception {
		System.out.println("---------------execute");
		return SUCCESS;  //在接口中定义了一些常量，防止写错。
	}
}
