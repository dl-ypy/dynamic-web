package com.ypy.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.AdministratorDao;
import com.ypy.dao.RegisterDao;
import com.ypy.model.Administrator;
import com.ypy.model.User;
/**
 * 用户注册时（管理员添加）的一些业务操作
 * @author ypy
 */
public class RegisterService {
	private RequestDispatcher dis = null;
	/**
	 * 判断要用户注册后跳转到哪个页面
	 * @param response
	 * @param request
	 * @param user 用户类
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void userJump(HttpServletResponse response, HttpServletRequest request, User user) throws IOException, ServletException {
		RegisterDao rs = new RegisterDao();
		if (rs.userExist(user.getUsername(), "user")) {
			System.out.println("用户已存在！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/register.jsp");
		} else {
			if (rs.userRegister(user) != 0) {
				System.out.println("注册成功！");
				dis = request.getRequestDispatcher("login.jsp");
			} else {
				System.out.println("注册失败！");
			}
		}
		dis.forward(request, response);
	}
	
	/**
	 * 判断要管理员添加后跳转到哪个页面
	 * @param response
	 * @param request
	 * @param admin 管理员类
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void adminJump(HttpServletResponse response, HttpServletRequest request, Administrator admin) throws IOException, ServletException {
		RegisterDao rs = new RegisterDao();
		AdministratorDao admindao = new AdministratorDao();
		if (rs.userExist(admin.getUsername(), "admin")) {
			System.out.println("用户已存在！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/adminList.jsp");
		} else {
			if (admindao.adminAdd(admin) != 0) {
				System.out.println("添加成功！");
				dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/adminList.jsp");
			} else {
				System.out.println("添加失败！");
			}
		}
		dis.forward(request, response);
	}
}
