package com.ypy.service;

import com.ypy.dao.UserDao;
import com.ypy.dao.impl.UserDaoImpl;
import com.ypy.model.User;

/**
 * 业务层，对外公开
 */
public class UserService {
	private UserDao userdao = new UserDaoImpl();

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public void add(User u) {
		this.userdao.save(u);
	}
}
