package com.ypy.registeration.userservice;
import org.junit.Assert;
import org.junit.Test;

import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;
import com.ypy.registeration.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Test
	public void testExists() throws Exception {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("ypy");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);//���뷵�ص���true���������true��ͨ��
	}

	@Test
	public void testAdd() throws Exception {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("e");
		u.setPassword("555");
		boolean exists = um.exists(u);//���ж����ݿ��д��ڲ�����
		if (!exists) {//�����ھ�add
			um.add(u);
			u.setUsername("e");//add���ٴ������ͬ�û����ж��Ƿ����
			exists = um.exists(u);
			Assert.assertEquals(true, exists);//������ڵĻ��ͱ�ʾ��ӳɹ�
		} else {
			Assert.fail("user exited!");
		}
	}

}
