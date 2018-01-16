package com.Struts2_0150_fangwenwebyuanshu.user;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//设计思想
//DI    依赖注入         依赖struts2容器注入的
//IoC   控制反转         原来自己控制，现在被别人控制
public class LoginAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private Map<String, Object> request;//这里用的是范式  实现了RequestAware接口(struts2自己有的)  就说明里面就有了request了(spring初始化的)
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	public String execute()
	{
		request.put("r1", "rrrrrrrrrrrrrr");
		session.put("s", "value");
		application.put("a1", "aaaaaaaaaaaaa");
		return SUCCESS;
	}

	//实现的接口要求提供的方法      放置值
	public void setApplication(Map<String, Object> application) {//参数是Map类型的
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Map<String, Object> getApplication() {
		return application;
	}
}
