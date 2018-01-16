package com.ypy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ypy.model.User;
import com.ypy.service.RegisterService;

/**
 * 普通用户注册的servlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String security = request.getParameter("security");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		String[] hobby = request.getParameterValues("hobby");
		StringBuffer hobbies = new StringBuffer();
		//防止hobby为空时报空指针错误
		if (hobby != null) {
			for (int i=0; i<hobby.length; i++) {
				if (i == (hobby.length-1)) {
					hobbies.append(hobby[i]);
				} else {
					hobbies.append(hobby[i]).append("、");
				}
			}
		} else {
			hobbies.append("无");
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPhone(phone);
		user.setSecurity(security);
		user.setAnswer(answer);
		user.setEmail(email);
		user.setHobby(hobbies.toString());
		RegisterService rs = new RegisterService();
		rs.userJump(response, request, user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
