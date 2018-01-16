package com.ypy.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class HelloController {

	//springMVC转发(需要视图解析器)
	@RequestMapping("/hello")
	public String hello() {
		return "index";
	}
	
	//springMVC转发(不需要视图解析器)方法1
	@RequestMapping("/hello1")
	public String hello1() {
		return "WEB-INF/jsp/index.jsp";
	}
	
	//springMVC转发(不需要视图解析器)方法2
	@RequestMapping("/hello2")
	public String hello2() {
		return "forward:WEB-INF/jsp/index.jsp";
	}
	
	//springMVC重定向(不需要视图解析器)
	@RequestMapping("/hello3")
	public String hello3() {
		return "redirect:index.jsp";//跳转不到WEB-INF目录下
	}
	
	//Servlet转发(不需要视图解析器)
	@RequestMapping("/hello4")
	public void hello4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", "Servlet转发");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	//Servlet重定向(不需要视图解析器)
	@RequestMapping("/hello5")
	public void hello5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}
	
	//Servlet直接显示(不需要视图解析器)
	@RequestMapping("/hello6")
	public void hello6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("servlet 显示");
	}

}
