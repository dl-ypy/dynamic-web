package com.ypy.registeration.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.ypy.registeration.dao.UserDao;
import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager {
	private UserDao userDao;//用spring依赖注入就不用new了
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
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
