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
 * �û�ע��ʱ������Ա��ӣ���һЩҵ�����
 * @author ypy
 */
public class RegisterService {
	private RequestDispatcher dis = null;
	/**
	 * �ж�Ҫ�û�ע�����ת���ĸ�ҳ��
	 * @param response
	 * @param request
	 * @param user �û���
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void userJump(HttpServletResponse response, HttpServletRequest request, User user) throws IOException, ServletException {
		RegisterDao rs = new RegisterDao();
		if (rs.userExist(user.getUsername(), "user")) {
			System.out.println("�û��Ѵ��ڣ�");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/register.jsp");
		} else {
			if (rs.userRegister(user) != 0) {
				System.out.println("ע��ɹ���");
				dis = request.getRequestDispatcher("login.jsp");
			} else {
				System.out.println("ע��ʧ�ܣ�");
			}
		}
		dis.forward(request, response);
	}
	
	/**
	 * �ж�Ҫ����Ա��Ӻ���ת���ĸ�ҳ��
	 * @param response
	 * @param request
	 * @param admin ����Ա��
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void adminJump(HttpServletResponse response, HttpServletRequest request, Administrator admin) throws IOException, ServletException {
		RegisterDao rs = new RegisterDao();
		AdministratorDao admindao = new AdministratorDao();
		if (rs.userExist(admin.getUsername(), "admin")) {
			System.out.println("�û��Ѵ��ڣ�");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/adminList.jsp");
		} else {
			if (admindao.adminAdd(admin) != 0) {
				System.out.println("��ӳɹ���");
				dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/adminList.jsp");
			} else {
				System.out.println("���ʧ�ܣ�");
			}
		}
		dis.forward(request, response);
	}
}
