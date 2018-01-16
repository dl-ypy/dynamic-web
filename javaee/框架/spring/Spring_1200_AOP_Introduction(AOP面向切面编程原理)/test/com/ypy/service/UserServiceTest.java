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
		UserDao userDao = new UserDaoImpl();//被代理对象
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDao);
		//产生代理																								这里是被代理对象实现的接口
		UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, li);
		userDaoProxy.save(new User());
		userDaoProxy.delete();
	}

}
