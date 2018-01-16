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
	public void testSave() {
		Student s = new Student();
		s.setName("s1");
		s.setScore(80);
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("中级");
		Session s1 = sf.getCurrentSession();
		s1.beginTransaction();
		s1.save(s);
		s1.save(t);
		s1.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student s1 = (Student)s.load(Student.class, 9);
		System.out.println(s1.getScore());
		Teacher u = (Teacher)s.load(Teacher.class, 10);
		System.out.println(u.getTitle());
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













