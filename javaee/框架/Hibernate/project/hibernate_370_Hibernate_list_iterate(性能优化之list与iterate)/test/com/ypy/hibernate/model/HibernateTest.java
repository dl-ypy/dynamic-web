package com.ypy.hibernate.model;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
//用junit进行测试，首先需要导入Junit的jar包
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
public class HibernateTest {
	
	private static SessionFactory sf = null;
	
	@BeforeClass    
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testSave() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		for(int i=0; i<10; i++) {//创建10个版块
			Category c = new Category();
			c.setName("c" + i);
			Topic t = new Topic();
			t.setTitle("t" + i);
			t.setCategory(c);
			t.setCreateDate(new Date());
			session.save(c);
			session.save(t);
		}
		session.getTransaction().commit();
	}
	
	//list与iterate的区别一：list会直接查询所有记录，而iterate会查询id，当用到时才会从数据库中查询。
	@Test
	public void testQueryList() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Category> categorys = (List<Category>)session.createQuery("from Category").list();
		for (Category c : categorys) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
	}

	@Test
	public void testQueryIterate() {
		Session session = sf.openSession();
		session.beginTransaction();
		Iterator<Category> categorys = (Iterator<Category>)session.createQuery("from Category").iterate();
		while (categorys.hasNext()) {
			Category c = categorys.next();
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
	}
	
	//list与iterate的区别二：iterate会读取session中的缓存，而list不会。
	//下面例子，两个categorys，list会查询两次，而iterate会查询一次id，第二次会读取session级的缓存。
	@Test
	public void testQueryList2() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Category> categorys = (List<Category>)session.createQuery("from Category").list();
		for (Category c : categorys) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		List<Category> categorys2 = (List<Category>)session.createQuery("from Category").list();
		for (Category c : categorys2) {
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
	}

	@Test
	public void testQueryIterate2() {
		Session session = sf.openSession();
		session.beginTransaction();
		Iterator<Category> categorys = (Iterator<Category>)session.createQuery("from Category").iterate();
		while (categorys.hasNext()) {
			Category c = categorys.next();
			System.out.println(c.getId() + "-" + c.getName());
		}
		Iterator<Category> categorys2 = (Iterator<Category>)session.createQuery("from Category").iterate();
		while (categorys2.hasNext()) {
			Category c = categorys2.next();
			System.out.println(c.getId() + "-" + c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test  
	public void testOnetoOne(){  //创建数据库
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	
	@AfterClass   
	public static void afterClass() {
		sf.close();
	}

}













