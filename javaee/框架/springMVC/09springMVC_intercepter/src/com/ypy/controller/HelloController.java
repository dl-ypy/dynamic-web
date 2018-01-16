package com.ypy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("interceptor");
		return "index.jsp";
	}

}
