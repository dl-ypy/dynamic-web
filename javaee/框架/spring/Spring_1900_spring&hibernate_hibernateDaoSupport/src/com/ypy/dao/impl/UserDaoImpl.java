package com.ypy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao��ʵ��
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
		hibernateTemplate.save(u);  //ֱ����hibernateTemplate���á�
		//throw new RuntimeException("error!");    //�ֶ��׳�RuntimeException����������᲻���Զ��ع�
												 //���л����ҵ���׳��쳣�������ݿ���Ҳ����������ݣ���Ϊ�Ѿ��Զ��ع���
	}
}
