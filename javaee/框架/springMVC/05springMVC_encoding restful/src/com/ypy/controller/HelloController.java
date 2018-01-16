package com.ypy.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class HelloController {
	
	@RequestMapping("/hello") 
	public String hello2(@RequestParam("uname")String name, ModelMap model) {
		model.addAttribute("name", name);
		return "index.jsp";
	}
	
	//É¾³ý
	@RequestMapping("/delete/{id}/{uid}") 
	public String delete(@PathVariable int id, @PathVariable int uid) {
		System.out.println("id=" + id);
		System.out.println("uid=" + uid);
		return "/index.jsp";
	}
}
