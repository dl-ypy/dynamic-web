package com.ypy.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(1);
		s.setName("zhangsan");
		s.setAge(8);
		
		Configuration cfg = new Configuration();//用来读取配置文件
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();//事务开始
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
