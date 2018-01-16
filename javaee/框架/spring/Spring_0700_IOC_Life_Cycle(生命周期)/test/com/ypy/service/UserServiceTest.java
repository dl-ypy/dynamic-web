package com.ypy.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom2.JDOMException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ypy.dao.UserDao;

public class UserServiceTest {

	@Test
	public void addtest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//这里必须用ClassPathXmlApplicationContext，因为在该类中才有destroy方法。
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService)ctx.getBean("userService");
		
		ctx.destroy();
	}

}
