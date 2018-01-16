package com.ypy.hibernate.model;
import java.util.EnumSet;

import org.hibernate.LockMode;
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
		
		Account a = new Account();
		a.setBalance(100);
		session.save(a);
			
		session.getTransaction().commit();
	}
	
	//�����������
	@Test
	public void testOperation1() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Account a = (Account)session.load(Account.class, 1);
		int balance = a.getBalance();
		balance = balance - 10;
		//��ʱ����������������balance��ֵ�������ȥ��ֵ�ͺ���ʵֵ��ͬ��
		a.setBalance(balance);
		session.getTransaction().commit();
	}
	
	//���˱�����
	@Test
	public void testPessimisticLock() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Account a = (Account)session.load(Account.class, 1, LockMode.UPGRADE);//�ڴ˹����м���
		int balance = a.getBalance();
		balance = balance - 10;
		a.setBalance(balance);
		session.getTransaction().commit();
	}
	
	
	//���ֹ������������Ϊ��¼���µ�version�ı��ˣ������˵����������������˸��£�������δ���Ϳ�Ҫ������
	@Test
	public void testOptimisticLock() {
		Session session = sf.openSession();
		Session session2 = sf.openSession();
		session.beginTransaction();
		Account a1 = (Account) session.load(Account.class, 1);
		

		session2.beginTransaction();
		Account a2 = (Account) session2.load(Account.class, 1);
		
		a1.setBalance(900);
		a2.setBalance(1100);

		session.getTransaction().commit();
		System.out.println(a1.getVersion());

		session2.getTransaction().commit();
		System.out.println(a2.getVersion());

		session.close();
		session2.close();
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













