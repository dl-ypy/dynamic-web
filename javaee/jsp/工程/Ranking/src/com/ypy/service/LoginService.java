package com.ypy.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.LoginDao;
/**
 * 用户或管理员登录时的一些业务操作
 * @author ypy
 */
public class LoginService {
	private RequestDispatcher dis = null;
	/**
	 * 判断用户登录要跳转到哪个页面
	 * @param username 用户名
	 * @param password 用户密码
	 * @param response
	 * @param request
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void userJump(String username, String password, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		LoginDao ls = new LoginDao();
		if (ls.userExist(username, password, "user")) {
			dis = request.getRequestDispatcher("WEB-INF/jsp/front/index.jsp");
		} else {
			dis = request.getRequestDispatcher("login");
		}
		dis.forward(request, response);
	}
	
	/**
	 * 判断管理者要跳转到哪个页面
	 * @param username 管理员名字
	 * @param password
	 * @param response
	 * @param request
	 * @throws IOException
	 * @throws ServletException
	 */
	public void adminJump(String username, String password, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		LoginDao ls = new LoginDao();
		if (ls.userExist(username, password, "admin")) {
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/list.jsp");
		} else {
			dis = request.getRequestDispatcher("adminLogin.jsp");
		}
		dis.forward(request, response);
	}
}
