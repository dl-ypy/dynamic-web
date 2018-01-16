package com.ypy.dao.impl;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDaoµÄÊµÏÖ
 */
public class UserDaoImpl implements UserDao{

	@Override
	public void save(User u) {
		System.out.println("saved!");
	}

	@Override
	public void delete() {
		System.out.println("delete!");
	}
	
}
