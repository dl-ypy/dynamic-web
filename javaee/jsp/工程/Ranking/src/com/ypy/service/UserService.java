package com.ypy.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.dao.UserDao;
import com.ypy.model.User;
/**
 * 操作用户数据的一些业务操作
 * @author ypy
 */
public class UserService {
	private RequestDispatcher dis = null;
	UserDao userdao = new UserDao();
	int count = 0;
	/**
	 * 删除用户的业务操作，判断是否删除成功并且跳转
	 * @param id 所删除用户的id
	 * @param response
	 * @param request
	 * @throws IOException
	 * @throws ServletException 
	 */
	public void userRemove(int id, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		count = userdao.userRemove(id);
		if (count != 0) {
			System.out.println("删除成功！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/list.jsp");
		} else {
			System.out.println("删除失败！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/admin/list.jsp");
		}
		dis.forward(request, response);
	}
	
	/**
	 * 修改用户信息
	 * @param user 用户类
	 * @param response
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userUpdate(User user, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		count = userdao.userUpdate(user);
		if (count != 0) {
			System.out.println("修改成功！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/myList.jsp?username='"+user.getUsername()+"'&password='"+user.getPassword()+"'");
		} else {
			System.out.println("修改失败！");
			dis = request.getRequestDispatcher("WEB-INF/jsp/back/user/myList.jsp?username='"+user.getUsername()+"'&password='"+user.getPassword()+"'");
		}
		dis.forward(request, response);
	}
}
