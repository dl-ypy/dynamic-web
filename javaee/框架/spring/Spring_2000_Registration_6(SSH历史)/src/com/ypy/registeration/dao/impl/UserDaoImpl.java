package com.ypy.registeration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ypy.registeration.dao.UserDao;
import com.ypy.registeration.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTmplate;

	public HibernateTemplate getHibernateTmplate() {
		return hibernateTmplate;
	}

	@Resource
	public void setHibernateTmplate(HibernateTemplate hibernateTmplate) {
		this.hibernateTmplate = hibernateTmplate;
	}

	@Override
	@Transactional
	public void save(User u) {
		hibernateTmplate.save(u);
	}

	@Override
	
	public boolean CheckUserExistsWithName(String username) {
		List<User> users = (List<User>) hibernateTmplate.find("from User u where u.username = '"+ username +"'");
		
		if (users!=null && users.size()>0) {
			return true;
		}
		return false;
	}
}
