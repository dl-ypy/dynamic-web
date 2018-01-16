package com.ypy.hibernate.model;
import java.util.Date;

//��junit���в��ԣ�������Ҫ����Junit��jar��
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
/* ʱ�䣺2016��12��21��15:51:02
 * Ŀ�ģ����Ŀ����ӿڡ�
 */
public class TeacherTest {
	
	private static SessionFactory sf = null;
	
	@BeforeClass    
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
		                         //configure()Ĭ���ҵ��ļ�����hibernate.cfg.xml
								 //��������ļ������ˣ�д��configure("�����ļ���")
	}
	
	@Test  
	//���
	public void TeachertestSave() {
		/*���������״̬��transient,persistent,detached��
		transient���ڴ���һ������û��ID��������Ҳû��
		persistent���ڴ����У��������У����ݿ��У���ID
		detached���ڴ��У�����û�У����ݿ��У���ID*/
		
		//״̬һ��transient
		Teacher t = new Teacher();
		t.setId(3);
		t.setName("lisi");
		t.setTitle("�߼�");
		t.setBirthDay(new Date());   
		t.setZhicheng(Zhicheng.A);
		
		//Session session = sf.openSession();
		Session session = sf.getCurrentSession();
											//openSession()��ÿ�ζ���Ҫ����session����Ҫclose
											//getCurrentSession()��������(hibernate.cfg.xml�����ļ���)�ң�����У��þɵģ����û�У����µģ������ύ����Զ�close
											//getCurrentSession()����;���綨����߽�
											//���ֲ��ܻ���
		session.beginTransaction();
		session.save(t);
		//״̬����persistent
		session.getTransaction().commit();
		//session.close();
		
		//״̬����detached
	}
	
	@Test  
	//ɾ��
	public void TeachertestDelete() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("lisi");
		t.setTitle("�ͼ�");
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
	//�����ݿ�ȡһ����¼��Load��
	public void TeachertestLoad() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 3);  //��һ��������Ҫת�ɵ�class���ڶ���������(ID��)
		System.out.println(t.getName());
		session.getTransaction().commit();
	}
	
	@Test  
	//�����ݿ�ȡһ����¼��Get��
	public void TeachertestGet() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 3);  //��һ��������Ҫת�ɵ�class���ڶ���������(ID��)
		//System.out.println(t.getName());
		session.getTransaction().commit();
		System.out.println(t.getName());
		/*��get�ܹ����ύ��ʹ��t������Ϊgetֱ�Ӵ����ݿ���أ������ӳ�
		��load���ص��Ǵ�����󣬵ȵ������õ����������ʱ�Żᷢ��sql���*/
	}
	
	@AfterClass   
	public static void afterClass() {
		sf.close();
	}

}













