package com.ypy.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.UserDao;
import com.ypy.model.User;
/**
 * �����û����ݵ�һЩҵ�����
 * @author ypy
 */
public class UserService {
	private RequestDispatcher dis = null;
	UserDao userdao = new UserDao();
	int count = 0;
	/**
	 * ɾ���û���ҵ��������ж��Ƿ�ɾ���ɹ�������ת
	 * @param id ��ɾ���û���id
	 * @param response
	 * @param request
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void userRemove(int id, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		count = userdao.userRemove(id);
		if (count != 0) {
			System.out.println("ɾ���ɹ���");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/list.jsp");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/list.jsp");
		}
		dis.forward(request, response);
	}
	
	/**
	 * �޸��û���Ϣ
	 * @param user �û���
	 * @param response
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userUpdate(User user, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		count = userdao.userUpdate(user);
		if (count != 0) {
			System.out.println("�޸ĳɹ���");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/myList.jsp?username='"+user.getUsername()+"'&password='"+user.getPassword()+"'");
		} else {
			System.out.println("�޸�ʧ�ܣ�");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/myList.jsp?username='"+user.getUsername()+"'&password='"+user.getPassword()+"'");
		}
		dis.forward(request, response);
	}
}
