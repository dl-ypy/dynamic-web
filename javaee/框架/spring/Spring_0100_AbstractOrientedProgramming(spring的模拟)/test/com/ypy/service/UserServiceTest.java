package com.ypy.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom2.JDOMException;
import org.junit.Test;

import com.ypy.model.User;
import com.ypy.spring.BeanFactory;
import com.ypy.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void addtest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		BeanFactory factory = new ClassPathXmlApplicationContext();
		UserService service = (UserService)factory.getBean("userService");
		User u = new User();
		service.add(u);
	}

}
