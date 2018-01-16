package com.ypy.hibernate.model;
import java.util.EnumSet;

//��junit���в��ԣ�������Ҫ����Junit��jar��
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
/* ʱ�䣺2017��3��20��09:30:43
 * Ŀ�ģ�����������
 */
public class OnetoOneTest {
	
	private static SessionFactory sf = null;
	
	//@BeforeClass    
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
		                         //configure()Ĭ���ҵ��ļ�����hibernate.cfg.xml
								 //��������ļ������ˣ�д��configure("�����ļ���")
	}
	
	@Test  
	public void testOnetoOne(){  //�������ݿ�
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













