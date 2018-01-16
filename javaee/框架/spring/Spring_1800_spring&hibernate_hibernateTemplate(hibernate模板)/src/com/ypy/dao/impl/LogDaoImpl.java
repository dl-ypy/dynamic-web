package com.ypy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.ypy.dao.LogDao;
import com.ypy.dao.UserDao;
import com.ypy.model.Log;
import com.ypy.model.User;

/**
 * UserDaoµÄÊµÏÖ
 */

@Component
public class LogDaoImpl implements LogDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Log log) {
		Session session = sessionFactory.getCurrentSession();
		session.save(log);
	}
}
