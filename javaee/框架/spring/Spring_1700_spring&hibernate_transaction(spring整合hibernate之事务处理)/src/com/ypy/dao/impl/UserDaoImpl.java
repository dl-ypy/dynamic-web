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
 * UserDao的实现
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
		Session session = sessionFactory.getCurrentSession();//这里只需写这两句，而且必须用getCurrentSession()，得到上下文中的session
		session.save(u);
		//throw new RuntimeException("error!");    //手动抛出RuntimeException，测试事务会不会自动回滚
												 //运行会出错，业务抛出异常，而数据库中也不会添加数据，因为已经自动回滚了
	}
}
