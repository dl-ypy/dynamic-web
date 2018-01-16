package com.ypy.hibernate.model;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

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
		Session session = sf.openSession();
		session.beginTransaction();
		
		for(int i=0; i<10; i++) {//����10�����
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
	
	//�������һ������fetch=FetchType.LAZY
	@Test
	public void testQuery1() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createQuery("from Topic").list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			//System.out.println(t.getCategory().getName());  //����ΪLAZYʱ�������õ����������ı�ʱ�Ż��ѯ������
		}
		session.getTransaction().commit();
	}

	//�����������ʹ��createCriteria(Topic.class)
	@Test
	public void testQuery2() {
		Session session = sf.openSession();
		session.beginTransaction();
		List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
			System.out.println(t.getCategory().getName());  //��ʹ�õ�������Ҳ�����ѯ������
		}
		session.getTransaction().commit();
	}
	
	//�����������ʹ��BatchSize��Ҫ��һ�Զ��һ��һ������BatchSize
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
	
	//��������ģ�ʹ��join fetch���ı��ѯ���
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













