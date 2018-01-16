package com.ypy.hibernate.model;
import java.util.EnumSet;

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
	//保存多的一方，在User类中设置cascade，在多的一方设置比较容易
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
	//保存单的一方,在Group类中设置cascade，在单的一方设置比较麻烦
	public void testSaveGroup() {
		User u = new User();
		u.setName("u2");
		User u1 = new User();
		u1.setName("u3");
		Group g = new Group();
		g.setName("g2");
		g.getUser().add(u);   //需要将User添加到Group中
		g.getUser().add(u1);
		u.setGroup(g);//这里必须设
		u1.setGroup(g);
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(g);
		s.getTransaction().commit();
	}
	
	@Test
	//从多的一方get，默认能够从关联表中取信息
	public void testGetUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 30);//从User中取出，此时就会有select语句
											 //后面的数字表示主键，如果表中没有，就会出错
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//从单的一方get，默认不能能够从关联表中取信息，需要在Group类中设置fetch，其默认为LAZY（懒惰的）
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
	//从多的一方load，load是通过session的代理，load时不能将两边的fetch都设置成EAGER，否则就会多查询表。
	public void testLoadUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.load(User.class, 30);//load方法只有使用时才会调用select语句
		System.out.println(u.getName());
		s.getTransaction().commit();
	}
	
	@Test
	//从单的一方load
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
	//更新，CascadeType最好都写ALL，否则，其他的类型只有当调用对应的方法时才能进行关联的修改。
	public void testUpdateUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		User u = (User)s.get(User.class, 30);   //先get到
		s.getTransaction().commit();
		u.setName("user");
		u.getGroup().setName("group");
		Session s1 = sf.getCurrentSession();//再新建一个session
		s1.beginTransaction();
		s1.update(u);
		s1.getTransaction().commit();
	}
	
	@Test
	//从多的一方删除
	public void testDeleteUser() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//User u = (User)s.load(User.class, 4);
		//s.delete(u);  不能用delete，因为删除时会删除对应的group，并且把与对应group相关联的user也都删除掉。
		s.createQuery("delete from User u where id = 7").executeUpdate();//要用这种写法
		s.getTransaction().commit();
	}
	
	@Test
	//从单的一方删除，从单的一方删除允许把其对应的多的一方删除掉，如果不删除，就相当于是垃圾数据了
	//如果不想删掉，也可以使用createQuery
	public void testDeleteGroup() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Group g = (Group)s.load(Group.class, 12);
		s.delete(g);  
		s.getTransaction().commit();
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













