package com.ypy.dao.impl;
/**
 * ���࣬������ʵ�����impl���̳�����࣬�Ͳ���ʹ��ÿ��impl�඼��ͨ��XML���õķ�ʽʹ��HibernateDaoSupport
 */
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class SuperDAO extends HibernateDaoSupport{
	@Resource(name="sessionFactory")    //ʹ�������ļ��е�sessionFactory��Դ
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
