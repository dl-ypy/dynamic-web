package com.ypy.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	//哪些URL需要拦截，哪些不需要
	private List<String> allowedPass;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		String url = req.getRequestURI().toString();
		//先判断session中是否有
		Object user = req.getSession().getAttribute("user");
		if (user != null)//如果session中有，说明已经登录过，放行
			return true;
		for (String temp : allowedPass) {
			if (url.endsWith(temp)) {
				return true;
			}
		}
		//如果被拦截，重定向到登录页面
		System.out.println("-------------被拦截！-----------");
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
	
	//要设置allowedPass的set方法
	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
}
