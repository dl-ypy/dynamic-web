package com.Struts2_0150_fangwenwebyuanshu.user;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//���˼��
//DI    ����ע��         ����struts2����ע���
//IoC   ���Ʒ�ת         ԭ���Լ����ƣ����ڱ����˿���
public class LoginAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private Map<String, Object> request;//�����õ��Ƿ�ʽ  ʵ����RequestAware�ӿ�(struts2�Լ��е�)  ��˵�����������request��(spring��ʼ����)
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	public String execute()
	{
		request.put("r1", "rrrrrrrrrrrrrr");
		session.put("s", "value");
		application.put("a1", "aaaaaaaaaaaaa");
		return SUCCESS;
	}

	//ʵ�ֵĽӿ�Ҫ���ṩ�ķ���      ����ֵ
	public void setApplication(Map<String, Object> application) {//������Map���͵�
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
