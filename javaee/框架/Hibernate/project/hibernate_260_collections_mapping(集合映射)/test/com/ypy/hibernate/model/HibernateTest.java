package com.ypy.hibernate.model;
import java.util.EnumSet;
import java.util.Map;

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
	//从多的一方load，load是通过session的代理，load时不能将两边的fetch都设置成EAGER，否则就会多查询表。
	public void testLoadUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.load(User.class, 1);//load方法只有使用时才会调用select语句
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//从单的一方load
	public void testLoadGroup() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.load(Group.class, 2);
		for (Map.Entry<Integer, User> entry : g.getUser().entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		s.getTransaction().commit();
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













