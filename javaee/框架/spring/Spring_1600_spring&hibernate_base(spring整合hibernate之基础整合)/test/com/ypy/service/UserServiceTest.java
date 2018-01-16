package com.ypy.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom2.JDOMException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

public class UserServiceTest {

	@Test
	public void addtest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = (UserService)ctx.getBean("userService");
		service.add(new User());
	}

}
