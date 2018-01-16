package com.ypy.hibernate.model;
import java.util.Date;
import java.util.EnumSet;
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
	
	//解决方法一：设置fetch=FetchType.LAZY
	@Test
	public void testQuery1() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			//System.out.println(t.getCategory().getName());  //设置为LAZY时，这里用到其他关联的表时才会查询其他表
		}
		session.getTransaction().commit();
	}

	//解决方法二：使用createCriteria(Topic.class)
	@Test
	public void testQuery2() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			System.out.println(t.getCategory().getName());  //即使用到其他表，也不会查询其他表
		}
		session.getTransaction().commit();
	}
	
	//解决方法三：使用BatchSize，要在一对多的一的一方设置BatchSize
	@Test
	public void testQuery3() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	
	//解决方法四：使用join fetch，改变查询语句
	@Test
	public void testQuery4() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic t join fetch t.category c").list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
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













