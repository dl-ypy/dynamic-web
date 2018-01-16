package com.ypy.registeration.util;
/**
 * 创建sessionfactory的单例模式
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
