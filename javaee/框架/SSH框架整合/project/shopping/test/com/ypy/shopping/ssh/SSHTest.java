package com.ypy.shopping.ssh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ypy.shopping.model.Category;
import com.ypy.shopping.service.impl.CategoryServiceImpl;

public class SSHTest {

	@Test
	/*
	 * ≤‚ ‘spring
	 */
	public void spring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		System.out.println(context.getBean("date"));
	}

	@Test
	/*
	 * ≤‚ ‘hibernate
	 */
	public void hibernate() {
		System.out.println(HibernateSessionFactory.getSession());
	}
	
	@Test
	/*
	 * ≤‚ ‘spring”Îhibernate’˚∫œ
	 */
	public void springHibernate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		CategoryServiceImpl categoryServiceImpl = (CategoryServiceImpl) context.getBean("categoryServiceImpl");
		Category category = new Category("test", false, 1);
		categoryServiceImpl.save(category);
	}
}
