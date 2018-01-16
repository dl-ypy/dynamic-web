package com.ypy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class HelloController {

	@RequestMapping("/json")
	@ResponseBody
	public List<User> json(){ 
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"张三","男"));
		list.add(new User(2,"李四","男"));
		list.add(new User(3,"小红","女"));
		return list;
	}
}
