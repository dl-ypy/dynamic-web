package com.ypy.struts2.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User1Action extends ActionSupport{
	public String query() {
		System.out.println("-----------query------------");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		return SUCCESS;
	}
	
	public String save() {
		System.out.println("------------save-----------");
		ActionContext request = ActionContext.getContext();
		Map<String, Object> session = request.getSession();
		Map<String, Object> application = request.getApplication();
		request.put("req", "MsgReq");
		return SUCCESS;
	}
}
