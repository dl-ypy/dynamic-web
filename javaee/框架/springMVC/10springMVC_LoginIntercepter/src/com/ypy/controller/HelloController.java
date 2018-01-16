package com.ypy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ypy.model.User;

@org.springframework.stereotype.Controller
public class HelloController {

	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		if ("ypy".equals(user.getName()) && "1234".equals(user.getPassword())) {
			session.setAttribute("user", user);
			return "redirect:/index.jsp";
		}
		return "redirect:/login.jsp";
	}

	//用来测试会不会被拦截
	@RequestMapping("/add")
	public String add() {
		System.out.println("------------add--------------");
		return "redirect:/index.jsp";
	}
}
