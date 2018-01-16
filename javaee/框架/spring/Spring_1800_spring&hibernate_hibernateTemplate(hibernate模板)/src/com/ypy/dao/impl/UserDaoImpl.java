package com.ypy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao的实现
 */

@Component
public class UserDaoImpl implements UserDao{
	//private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User u) {
		hibernateTemplate.save(u);  //直接用hibernateTemplate调用。
		//throw new RuntimeException("error!");    //手动抛出RuntimeException，测试事务会不会自动回滚
												 //运行会出错，业务抛出异常，而数据库中也不会添加数据，因为已经自动回滚了
	}
}
