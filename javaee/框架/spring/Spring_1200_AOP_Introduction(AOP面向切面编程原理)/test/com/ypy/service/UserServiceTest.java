package com.ypy.service;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.ypy.aop.LogInterceptor;
import com.ypy.dao.UserDao;
import com.ypy.dao.impl.UserDaoImpl;
import com.ypy.model.User;

public class UserServiceTest {

	@Test
	public void testProxy() {
		UserDao userDao = new UserDaoImpl();//���������
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDao);
		//��������																								�����Ǳ��������ʵ�ֵĽӿ�
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, li);
		userDaoProxy.save(new User());
		userDaoProxy.delete();
	}

}
