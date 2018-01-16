package com.ypy.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.LoginDao;
/**
 * �û������Ա��¼ʱ��һЩҵ�����
 * @author ypy
 */
public class LoginService {
	private RequestDispatcher dis = null;
	/**
	 * �ж��û���¼Ҫ��ת���ĸ�ҳ��
	 * @param username �û���
	 * @param password �û�����
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
	 * �жϹ�����Ҫ��ת���ĸ�ҳ��
	 * @param username ����Ա����
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
