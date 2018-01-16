package com.ypy.registeration.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ypy.registeration.model.User;
import com.ypy.registeration.util.HibernateUtil;

public class UserManager {
	public boolean exists(User u) throws Exception{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		long count = (Long)s.createQuery("select count(*) from User u where u.username = :username")
				.setString("username", u.getUsername())
				.uniqueResult();
		s.getTransaction().commit();
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	public void add(User u) throws Exception{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
}
