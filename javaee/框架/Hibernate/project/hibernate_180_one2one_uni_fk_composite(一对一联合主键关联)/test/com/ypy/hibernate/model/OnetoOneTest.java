package com.ypy.hibernate.model;
import java.util.EnumSet;

//用junit进行测试，首先需要导入Junit的jar包
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
/* 时间：2017年3月20日09:30:43
 * 目的：联合主键。
 */
public class OnetoOneTest {
	
	private static SessionFactory sf = null;
	
	//@BeforeClass    
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
		                         //configure()默认找的文件就是hibernate.cfg.xml
								 //如果配置文件改名了，写成configure("配置文件名")
	}
	
	@Test  
	public void testOnetoOne(){  //创建数据库
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
	}
	//@AfterClass   
	public static void afterClass() {
		sf.close();
	}

}













