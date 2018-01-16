package com.ypy.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

	@Resource(name="u")   //@Resource，默认为byName，如果没有对应的名称，就变为byType
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public void add(User u) {
		this.userdao.save(u);
	}

}
