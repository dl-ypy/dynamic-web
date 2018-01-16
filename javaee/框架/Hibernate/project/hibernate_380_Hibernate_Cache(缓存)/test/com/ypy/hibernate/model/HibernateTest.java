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
	
	//一级缓存：同session下的缓存
	//同session下查询相同记录只执行一次查询语句
	@Test
	public void testCache1() {
		Session session = sf.openSession();
		session.beginTransaction();
		Category c = (Category)session.load(Category.class, 1);
		System.out.println(c.getName());
		Category c2 = (Category)session.load(Category.class, 1);
		System.out.println(c2.getName());
		session.getTransaction().commit();
	}
	
	//二级缓存：跨session的缓存
	@Test
	public void testCache2() {
		Session session = sf.openSession();
		session.beginTransaction();
		Category c = (Category)session.load(Category.class, 1);
		System.out.println(c.getName());
		session.getTransaction().commit();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Category c2 = (Category)session2.load(Category.class, 1);
		System.out.println(c2.getName());
		session2.getTransaction().commit();
	}
	
	//查询缓存
	@Test
	public void testQueryCache() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Category> categories = (List<Category>)session.createQuery("from Category")
				.setCacheable(true).list();//使用查询缓存
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		List<Category> categories2 = (List<Category>)session2.createQuery("from Category")
				.setCacheable(true).list();
		
		session2.getTransaction().commit();
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













