package com.ypy.hibernate.model;
import java.util.Date;

//用junit进行测试，首先需要导入Junit的jar包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
/* 时间：2016年12月21日15:51:02
 * 目的：核心开发接口。
 */
public class TeacherTest {
	
	private static SessionFactory sf = null;
	
	@BeforeClass    
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
		                         //configure()默认找的文件就是hibernate.cfg.xml
								 //如果配置文件改名了，写成configure("配置文件名")
	}
	
	@Test  
	//添加
	public void TeachertestSave() {
		/*对象的三种状态（transient,persistent,detached）
		transient：内存中一个对象，没有ID，缓存中也没有
		persistent：内存中有，缓存中有，数据库有，有ID
		detached：内存有，缓存没有，数据库有，有ID*/
		
		//状态一：transient
		Teacher t = new Teacher();
		t.setId(3);
		t.setName("lisi");
		t.setTitle("高级");
		t.setBirthDay(new Date());   
		t.setZhicheng(Zhicheng.A);
		
		//Session session = sf.openSession();
		Session session = sf.getCurrentSession();
											//openSession()是每次都需要更新session，需要close
											//getCurrentSession()从上下文(hibernate.cfg.xml配置文件中)找，如果有，用旧的，如果没有，建新的，事务提交后会自动close
											//getCurrentSession()的用途：界定事务边界
											//两种不能混用
		session.beginTransaction();
		session.save(t);
		//状态二：persistent
		session.getTransaction().commit();
		//session.close();
		
		//状态三：detached
	}
	
	@Test  
	//删除
	public void TeachertestDelete() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("lisi");
		t.setTitle("低级");
		t.setBirthDay(new Date());   
		t.setZhicheng(Zhicheng.B);
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
		
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		session2.delete(t);
		session2.getTransaction().commit();
	}
	
	@Test  
	//从数据库取一条记录（Load）
	public void TeachertestLoad() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 3);  //第一个参数是要转成的class，第二个是主键(ID号)
		System.out.println(t.getName());
		session.getTransaction().commit();
	}
	
	@Test  
	//从数据库取一条记录（Get）
	public void TeachertestGet() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 3);  //第一个参数是要转成的class，第二个是主键(ID号)
		//System.out.println(t.getName());
		session.getTransaction().commit();
		System.out.println(t.getName());
		/*用get能够在提交后使用t，是因为get直接从数据库加载，不会延迟
		而load返回的是代理对象，等到真正用到对象的内容时才会发出sql语句*/
	}
	
	@AfterClass   
	public static void afterClass() {
		sf.close();
	}

}













