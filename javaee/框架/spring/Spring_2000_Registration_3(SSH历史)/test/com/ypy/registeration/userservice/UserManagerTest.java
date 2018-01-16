package com.ypy.registeration.userservice;
/**
 * ����Junit���ԣ�����Ҫ��������
 */
import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;

import com.ypy.registeration.model.User;
import com.ypy.registeration.service.UserManager;

public class UserManagerTest {

	@Test
	public void testExists() throws Exception {
		UserManager um = new UserManager();
		User u = new User();
		u.setUsername("ypy");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);//���뷵�ص���true���������true��ͨ��
	}

	@Test
	public void testAdd() throws Exception {
		UserManager um = new UserManager();
		User u = new User();
		u.setUsername("d");
		u.setPassword("555");
		boolean exists = um.exists(u);//���ж����ݿ��д��ڲ�����
		if (!exists) {//�����ھ�add
			um.add(u);
			u.setUsername("d");//add���ٴ������ͬ�û����ж��Ƿ����
			exists = um.exists(u);
			Assert.assertEquals(true, exists);//������ڵĻ��ͱ�ʾ��ӳɹ�
		} else {
			Assert.fail("user exited!");
		}
	}

}
