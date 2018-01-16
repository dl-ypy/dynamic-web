package com.ypy.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ypy.persion.ChinesePersion;
import com.ypy.persion.JapansePersion;

public class DITest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ChinesePersion c = (ChinesePersion) ac.getBean("chinese");
		c.play();
		JapansePersion j = (JapansePersion) ac.getBean("japanse");
		j.play();
	}

}
