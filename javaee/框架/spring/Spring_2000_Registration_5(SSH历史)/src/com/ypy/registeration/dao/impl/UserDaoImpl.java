package com.ypy.registeration.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ypy.registeration.dao.UserDao;
import com.ypy.registeration.model.User;
import com.ypy.registeration.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User u) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}

	@Override
	public boolean CheckUserExistsWithName(String username) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from User u where u.username = :username")
				.setString("username", username)
				.uniqueResult();
		s.getTransaction().commit();
		if (count > 0) {
			return true;
		}
		return false;
	}
}
