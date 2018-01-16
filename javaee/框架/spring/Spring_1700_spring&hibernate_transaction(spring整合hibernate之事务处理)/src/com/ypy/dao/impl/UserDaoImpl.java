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
 * UserDao��ʵ��
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
		Session session = sessionFactory.getCurrentSession();//����ֻ��д�����䣬���ұ�����getCurrentSession()���õ��������е�session
		session.save(u);
		//throw new RuntimeException("error!");    //�ֶ��׳�RuntimeException����������᲻���Զ��ع�
												 //���л����ҵ���׳��쳣�������ݿ���Ҳ����������ݣ���Ϊ�Ѿ��Զ��ع���
	}
}
