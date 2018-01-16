package com.ypy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ypy.service.UserService;

@Controller//@Controller��Ӧ���ֲ��Bean��Ҳ����Action,��@Component��������
public class UserController {
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/list")
	public String list(ModelMap map) {
		map.addAttribute("list", userService.list());
		return "list.jsp";
	}
}
