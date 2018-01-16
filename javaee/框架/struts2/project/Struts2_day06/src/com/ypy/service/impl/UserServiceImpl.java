package com.ypy.service.impl;

import java.util.List;

import com.ypy.dao.IUserDao;
import com.ypy.dao.impl.UserDaoImpl;
import com.ypy.model.UserModel;
import com.ypy.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao dao = new UserDaoImpl();
	@Override
	public void save(UserModel user) throws RuntimeException {
		dao.save(user);
	}

	@Override
	public void update(UserModel user) throws RuntimeException {
		dao.update(user);
	}

	@Override
	public List<UserModel> query() throws RuntimeException {
		return dao.query();
	}

	@Override
	public UserModel queryById(int userid) throws RuntimeException {
		return dao.queryById(userid);
	}

	@Override
	public void delete(int userid) throws RuntimeException {
		dao.delete(userid);
	}

}
