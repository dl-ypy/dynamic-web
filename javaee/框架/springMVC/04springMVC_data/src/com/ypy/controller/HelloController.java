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
	//�ύ����
	
	//�ύ��ͨ����
	@RequestMapping("/hello") 
	/**
	 * @RequestParam("uname")�У�unameָ����ʱ��ַ��д�������ƣ�����������
	 */
	public String hello(@RequestParam("uname")String name) {
		System.out.println(name);
		return "index.jsp";
	}
	
	//�ύһ������
	@RequestMapping("/user")
	//�ύ��ʱ�����ֱ�Ӵ���������
	public String user(User user) {
		System.out.println(user);
		return "index.jsp";
	}
	
	//��������ʾ��UI��
	//ͨ��ModelAndView(��Ҫ������ͼ������)
	@RequestMapping("/modavie")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView m = new ModelAndView();
		//�൱��res.setAttribute("msg", "ModelAndView");
		m.addObject("msg", "ModelAndView");
		m.setViewName("index");
		return m;
	}
	
	//ͨ��ModelMap(����Ҫ������ͼ������)
	@RequestMapping("/modelmap") 
	public String hello2(@RequestParam("uname")String name, ModelMap model) {
		model.addAttribute("name", name);
		return "index.jsp";
	}
		
}
