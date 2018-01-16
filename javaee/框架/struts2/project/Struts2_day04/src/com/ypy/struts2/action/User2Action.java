package com.ypy.struts2.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User2Action extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String query() {
		System.out.println("-----------query------------"+request+","+response);
		return SUCCESS;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}
	
}
