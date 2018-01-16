package com.ypy.hibernate.model;
import java.util.Date;

//��junit���в��ԣ�������Ҫ����Junit��jar��
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	//���˵���ģʽ
	private static SessionFactory sf = null;
	
	@BeforeClass    //��ʾ��load���ڴ�֮��class֮ǰ����Ҫִ�еķ���
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Test  //˵�������������Ե�
	public void TeachertestSave() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("lisi");
		t.setTitle("�߼�");
		t.setBirthDay(new Date());   //Ĭ�ϻ���� ������ʱ����
		t.setZhicheng(Zhicheng.A);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
	
	@AfterClass   //������֮��
	public static void afterClass() {
		sf.close();
	}

}
