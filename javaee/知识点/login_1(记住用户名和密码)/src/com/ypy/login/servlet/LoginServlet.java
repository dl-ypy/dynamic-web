package com.ypy.login.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);//要写到转码的前面，否则传过去的就是转码后的
		username = URLEncoder.encode(username, "utf-8");//将中文进行转换，使得cookie能够保持中文
		String[] rembers = request.getParameterValues("rember");
		if (rembers != null) {
			String rember = rembers[0];
			if ("selected".equals(rember)) {
				Cookie nameCookie = new Cookie("username", username);
				Cookie pwdCookie = new Cookie("password", password);
				nameCookie.setMaxAge(60*60*24*10);
				pwdCookie.setMaxAge(60*60*24*10);
				nameCookie.setPath("/");
				pwdCookie.setPath("/");
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
			}
		}
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
