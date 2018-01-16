package com.bonc.test.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bonc.test.domain.UserModel;
import com.bonc.test.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/query")
	public String query(Model model) {
		List<UserModel> list = userService.query();
		model.addAttribute("userList", list);
		return "list";
	}
	
	@RequestMapping("/updateQuery")
	public String updateQuery(Model model, @RequestParam Map<String, Object> map) {
		List<UserModel> list = userService.queryById(Integer.parseInt(map.get("userid").toString()));
		model.addAttribute("user", list.get(0));
		return "updateList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam Integer userid) {
		userService.deleteById(userid);
		return "redirect:/query";
	}
	
	@RequestMapping("/addList")
	public String addList() {
		return "add";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Map<String, Object> map) {
		UserModel user = new UserModel();
		user.setUserid(Integer.parseInt(map.get("userid").toString()));
		user.setUsername(map.get("username").toString());
		user.setPassword(map.get("password").toString());
		userService.updateById(user);
		return "redirect:/query";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam Map<String, Object> map) {
		UserModel user = new UserModel();
		user.setUsername(map.get("username").toString());
		user.setPassword(map.get("password").toString());
		userService.add(user);
		return "redirect:/query";
	}
}
