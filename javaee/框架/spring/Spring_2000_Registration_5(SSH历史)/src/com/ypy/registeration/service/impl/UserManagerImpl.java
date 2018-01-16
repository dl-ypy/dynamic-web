package com.ypy.registeration.service.impl;

import com.ypy.registeration.dao.UserDao;
import com.ypy.registeration.dao.impl.UserDaoImpl;
import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;

public class UserManagerImpl implements UserManager {
	private UserDao userDao = new UserDaoImpl();
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean exists(User u){
		return userDao.CheckUserExistsWithName(u.getUsername());
	}
	
	@Override
	public void add(User u) throws Exception{
		userDao.save(u);
	}
}
