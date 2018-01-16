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
		Org o = new Org();
		o.setName("总公司");
		Org o1 = new Org();
		o1.setName("总公司下的分公司1");
		Org o2 = new Org();
		o2.setName("总公司下的分公司2");
		Org o11 = new Org();
		o11.setName("分公司1下的部门1");
		Org o12 = new Org();
		o12.setName("分公司1下的部门2");
		Org o21 = new Org();
		o21.setName("分公司2下的部门1");
		
		//添加孩子
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o2.getChildren().add(o21);
		
		//添加父亲
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
	
	//运用递归输出树状结构
	private void printf(Org o, int level) {
		String preStr = "";
		for (int i=0; i<level; i++) {//开始时level为0，所以总公司前面没有“----”
			preStr+="----";
		}
		System.out.println(preStr + o.getName());  
		for (Org c : o.getChildren()) {  
			printf(c,level+1);
		}
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













