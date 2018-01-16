package com.ypy.dao.impl;
/**
 * 超类，让所有实体类的impl都继承这个类，就不用使得每个impl类都得通过XML配置的方式使用HibernateDaoSupport
 */
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class SuperDAO extends HibernateDaoSupport{
	@Resource(name="sessionFactory")    //使用配置文件中的sessionFactory资源
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
