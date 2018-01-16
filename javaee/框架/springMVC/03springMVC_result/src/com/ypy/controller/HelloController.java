package com.ypy.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class HelloController {

	//springMVCת��(��Ҫ��ͼ������)
	@RequestMapping("/hello")
	public String hello() {
		return "index";
	}
	
	//springMVCת��(����Ҫ��ͼ������)����1
	@RequestMapping("/hello1")
	public String hello1() {
		return "WEB-INF/jsp/index.jsp";
	}
	
	//springMVCת��(����Ҫ��ͼ������)����2
	@RequestMapping("/hello2")
	public String hello2() {
		return "forward:WEB-INF/jsp/index.jsp";
	}
	
	//springMVC�ض���(����Ҫ��ͼ������)
	@RequestMapping("/hello3")
	public String hello3() {
		return "redirect:index.jsp";//��ת����WEB-INFĿ¼��
	}
	
	//Servletת��(����Ҫ��ͼ������)
	@RequestMapping("/hello4")
	public void hello4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", "Servletת��");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	//Servlet�ض���(����Ҫ��ͼ������)
	@RequestMapping("/hello5")
	public void hello5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
	}
	
	//Servletֱ����ʾ(����Ҫ��ͼ������)
	@RequestMapping("/hello6")
	public void hello6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("servlet ��ʾ");
	}

}
