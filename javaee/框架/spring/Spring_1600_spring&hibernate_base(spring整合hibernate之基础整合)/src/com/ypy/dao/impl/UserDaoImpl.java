package com.ypy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDaoµÄÊµÏÖ
 */

@Component
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User u) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		u.setId(1);
		u.setUsername("ypy");
		session.save(u);
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("saved!");
	}
}
