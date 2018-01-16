package com.ypy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		//��װҪ��ʾ����ͼ�е�����
		mv.addObject("msg", "hello springmvc");
		//��ͼ��
		mv.setViewName("hello");
		return mv;
	}

}
