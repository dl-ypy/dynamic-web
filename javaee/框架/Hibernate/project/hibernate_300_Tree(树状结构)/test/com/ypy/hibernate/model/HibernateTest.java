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
		Org o = new Org();
		o.setName("�ܹ�˾");
		Org o1 = new Org();
		o1.setName("�ܹ�˾�µķֹ�˾1");
		Org o2 = new Org();
		o2.setName("�ܹ�˾�µķֹ�˾2");
		Org o11 = new Org();
		o11.setName("�ֹ�˾1�µĲ���1");
		Org o12 = new Org();
		o12.setName("�ֹ�˾1�µĲ���2");
		Org o21 = new Org();
		o21.setName("�ֹ�˾2�µĲ���1");
		
		//��Ӻ���
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o2.getChildren().add(o21);
		
		//��Ӹ���
		o11.setParent(o1);
		o12.setParent(o1);
		o1.setParent(o);
		o2.setParent(o);
		o21.setParent(o2);
		
		Session s1 = sf.getCurrentSession();
		s1.beginTransaction();
		s1.save(o);
		s1.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Org o = (Org)s.load(Org.class, 1);
		printf(o,0);
		s.getTransaction().commit();
	}
	
	//���õݹ������״�ṹ
	private void printf(Org o, int level) {
		String preStr = "";
		for (int i=0; i<level; i++) {//��ʼʱlevelΪ0�������ܹ�˾ǰ��û�С�----��
			preStr+="----";
		}
		System.out.println(preStr + o.getName());  
		for (Org c : o.getChildren()) {  
			printf(c,level+1);
		}
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













