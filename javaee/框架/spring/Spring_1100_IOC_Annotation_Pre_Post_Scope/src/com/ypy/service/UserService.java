package com.ypy.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.dao.impl.UserDaoImpl;
import com.ypy.model.User;

/**
 * 业务层，对外公开
 */
@Component("userService")
@Scope("prototype")
public class UserService {
	private UserDao userdao = new UserDaoImpl();

	public UserDao getUserdao() {
		return userdao;
	}

	@Resource
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public void add(User u) {
		this.userdao.save(u);
	}

	@PostConstruct
	public void init() {
		System.out.println("-----init-----");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("-----destroy-----");
	}
}
