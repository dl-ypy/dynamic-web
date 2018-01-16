package com.Struts2_0130_DomainModel.user;
import com.Struts2_0130_DomainModel.model.*;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	//通过user调用其内部的属性
	private User user;   //struts2会自动创建对象
	
	public String add()
	{
		System.out.println("name="+user.getName());
		System.out.println("age="+user.getAge());
		return SUCCESS;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
}
