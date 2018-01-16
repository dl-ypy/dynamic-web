package com.ypy.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("lisi");
		t.setTitle("¸ß¼¶");
		
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}














