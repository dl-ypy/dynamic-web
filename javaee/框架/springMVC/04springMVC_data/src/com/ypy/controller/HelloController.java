package com.ypy.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ypy.model.User;

@org.springframework.stereotype.Controller
public class HelloController {
	//提交数据
	
	//提交普通数据
	@RequestMapping("/hello") 
	/**
	 * @RequestParam("uname")中，uname指访问时地址中写的域名称，即参数名称
	 */
	public String hello(@RequestParam("uname")String name) {
		System.out.println(name);
		return "index.jsp";
	}
	
	//提交一个对象
	@RequestMapping("/user")
	//提交的时候可以直接传递属性名
	public String user(User user) {
		System.out.println(user);
		return "index.jsp";
	}
	
	//将数据显示到UI层
	//通过ModelAndView(需要配置视图解析器)
	@RequestMapping("/modavie")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView m = new ModelAndView();
		//相当于res.setAttribute("msg", "ModelAndView");
		m.addObject("msg", "ModelAndView");
		m.setViewName("index");
		return m;
	}
	
	//通过ModelMap(不需要配置视图解析器)
	@RequestMapping("/modelmap") 
	public String hello2(@RequestParam("uname")String name, ModelMap model) {
		model.addAttribute("name", name);
		return "index.jsp";
	}
		
}
