package com.ypy.hibernate.model;
import java.util.Date;

//用junit进行测试，首先需要导入Junit的jar包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	//用了单例模式
	private static SessionFactory sf = null;
	
	@BeforeClass    //表示在load到内存之后，class之前马上要执行的方法
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Test  //说明是用来做测试的
	public void TeachertestSave() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("lisi");
		t.setTitle("高级");
		t.setBirthDay(new Date());   //默认会输出 年月日时分秒
		t.setZhicheng(Zhicheng.A);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass   //用完类之后
	public static void afterClass() {
		sf.close();
	}

}
