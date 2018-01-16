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
	//�Ӷ��һ��load��load��ͨ��session�Ĵ���loadʱ���ܽ����ߵ�fetch�����ó�EAGER������ͻ���ѯ��
	public void testLoadUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.load(User.class, 1);//load����ֻ��ʹ��ʱ�Ż����select���
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//�ӵ���һ��load
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













