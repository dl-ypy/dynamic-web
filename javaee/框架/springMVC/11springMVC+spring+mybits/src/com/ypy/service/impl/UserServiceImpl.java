package com.ypy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypy.dao.UserDao;
import com.ypy.model.User;
import com.ypy.service.UserService;

@Service("userService")//@Service��Ӧ����ҵ���Bean,��@Component��������
public class UserServiceImpl implements UserService{
	private UserDao userDao; 

	@Autowired//��@Resource����
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> list() {
		return userDao.list();
	}

}
