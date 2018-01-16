package com.ypy.hibernate.model;
import java.util.EnumSet;

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
	//������һ������User��������cascade���ڶ��һ�����ñȽ�����
	public void testSaveUser() {
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
	
	@Test
	//���浥��һ��,��Group��������cascade���ڵ���һ�����ñȽ��鷳
	public void testSaveGroup() {
		User u = new User();
		u.setName("u2");
		User u1 = new User();
		u1.setName("u3");
		Group g = new Group();
		g.setName("g2");
		g.getUser().add(u);   //��Ҫ��User��ӵ�Group��
		g.getUser().add(u1);
		u.setGroup(g);//���������
		u1.setGroup(g);
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(g);
		s.getTransaction().commit();
	}
	
	@Test
	//�Ӷ��һ��get��Ĭ���ܹ��ӹ�������ȡ��Ϣ
	public void testGetUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 30);//��User��ȡ������ʱ�ͻ���select���
											 //��������ֱ�ʾ�������������û�У��ͻ����
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//�ӵ���һ��get��Ĭ�ϲ����ܹ��ӹ�������ȡ��Ϣ����Ҫ��Group��������fetch����Ĭ��ΪLAZY������ģ�
	public void testGetGroup() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.get(Group.class, 29);
		for (User u : g.getUser()) {
			System.out.println(u.getName());
		}
		s.getTransaction().commit();
	}
	
	@Test
	//�Ӷ��һ��load��load��ͨ��session�Ĵ���loadʱ���ܽ����ߵ�fetch�����ó�EAGER������ͻ���ѯ��
	public void testLoadUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.load(User.class, 30);//load����ֻ��ʹ��ʱ�Ż����select���
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//�ӵ���һ��load
	public void testLoadGroup() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.load(Group.class, 29);
		for (User u : g.getUser()) {
			System.out.println(u.getName());
		}
		s.getTransaction().commit();
	}
	
	@Test
	//���£�CascadeType��ö�дALL����������������ֻ�е����ö�Ӧ�ķ���ʱ���ܽ��й������޸ġ�
	public void testUpdateUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 30);   //��get��
		s.getTransaction().commit();
		u.setName("user");
		u.getGroup().setName("group");
		Session s1 = sf.getCurrentSession();//���½�һ��session
		s1.beginTransaction();
		s1.update(u);
		s1.getTransaction().commit();
	}
	
	@Test
	//�Ӷ��һ��ɾ��
	public void testDeleteUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//User u = (User)s.load(User.class, 4);
		//s.delete(u);  ������delete����Ϊɾ��ʱ��ɾ����Ӧ��group�����Ұ����Ӧgroup�������userҲ��ɾ������
		s.createQuery("delete from User u where id = 7").executeUpdate();//Ҫ������д��
		s.getTransaction().commit();
	}
	
	@Test
	//�ӵ���һ��ɾ�����ӵ���һ��ɾ����������Ӧ�Ķ��һ��ɾ�����������ɾ�������൱��������������
	//�������ɾ����Ҳ����ʹ��createQuery
	public void testDeleteGroup() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.load(Group.class, 12);
		s.delete(g);  
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













