package com.ypy.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	//��ЩURL��Ҫ���أ���Щ����Ҫ
	private List<String> allowedPass;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		String url = req.getRequestURI().toString();
		//���ж�session���Ƿ���
		Object user = req.getSession().getAttribute("user");
		if (user != null)//���session���У�˵���Ѿ���¼��������
			return true;
		for (String temp : allowedPass) {
			if (url.endsWith(temp)) {
				return true;
			}
		}
		//��������أ��ض��򵽵�¼ҳ��
		System.out.println("-------------�����أ�-----------");
		resp.sendRedirect(req.getContextPath() + "/login.jsp");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	
	//Ҫ����allowedPass��set����
	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
}
