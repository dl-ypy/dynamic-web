package com.ypy.hibernate.model;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
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
	
	//list��iterate������һ��list��ֱ�Ӳ�ѯ���м�¼����iterate���ѯid�����õ�ʱ�Ż�����ݿ��в�ѯ��
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
	
	//list��iterate���������iterate���ȡsession�еĻ��棬��list���ᡣ
	//�������ӣ�����categorys��list���ѯ���Σ���iterate���ѯһ��id���ڶ��λ��ȡsession���Ļ��档
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













