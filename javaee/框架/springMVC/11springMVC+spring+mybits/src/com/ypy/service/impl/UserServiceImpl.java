package com.ypy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypy.dao.UserDao;
import com.ypy.model.User;
import com.ypy.service.UserService;

@Service("userService")//@Service对应的是业务层Bean,与@Component功能类似
public class UserServiceImpl implements UserService{
	private UserDao userDao; 

	@Autowired//与@Resource类似
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> list() {
		return userDao.list();
	}

}
