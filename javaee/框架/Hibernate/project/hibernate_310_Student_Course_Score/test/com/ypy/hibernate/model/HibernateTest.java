package com.ypy.hibernate.model;
import java.util.EnumSet;
import java.util.Map;

import org.hibernate.Session;
//��junit���в��ԣ�������Ҫ����Junit��jar��
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
		s.setName("����");
		Course c = new Course();
		c.setName("java");
		Score score = new Score();
		score.setCourse(c);
		score.setStudent(s);
		score.setScore(90);
		Session s1 = sf.getCurrentSession();
		s1.beginTransaction();
		s1.save(s);
		s1.save(c);
		//s1.save(score);
		s1.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student o = (Student)s.load(Student.class, 1);
		for (Course c : o.getCourses()) {
			System.out.println(c.getName());
		}
		s.getTransaction().commit();
	}
	
	@Test  
	public void testOnetoOne(){  //�������ݿ�
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













