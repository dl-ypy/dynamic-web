package com.ypy.hibernate.model;
import java.util.Date;
import java.util.EnumSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
//用junit进行测试，首先需要导入Junit的jar包
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
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
			session.save(c);
		}
		
		for(int i=0; i<10; i++) {//在id为1的版块创建10个主题
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			session.save(t);
			
		}
		
		for(int i=0; i<10; i++) {//在id为1的主题下创建10条回复
			
			Topic t = new Topic();
			t.setId(1);
			Msg m = new Msg();
			m.setCont("m" + i);
			m.setTopic(t);
			session.save(m);
			
		}
		session.getTransaction().commit();
	}
	
	
	
	//query by criteria query by example
		@Test
		public void testQBE() {
			Session session = sf.openSession();
			session.beginTransaction();
			Topic tExample = new Topic();
			tExample.setTitle("T_");
			
			Example e = Example.create(tExample)
						.ignoreCase().enableLike();//不区分大小写，使用like
			Criteria c = session.createCriteria(Topic.class)
						 .add(Restrictions.gt("id", 2))
						 .add(Restrictions.lt("id", 8))
						 .add(e)
						 ;
						 
			
			for(Object o : c.list()) {
				Topic t = (Topic)o;
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













