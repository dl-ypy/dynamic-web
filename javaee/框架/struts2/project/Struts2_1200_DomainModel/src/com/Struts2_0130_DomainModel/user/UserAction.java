package com.Struts2_0130_DomainModel.user;
import com.Struts2_0130_DomainModel.model.*;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	//ͨ��user�������ڲ�������
	private User user;   //struts2���Զ���������
	
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
