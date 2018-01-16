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
		Assert.assertEquals(true, exists);//设想返回的是true，如果返回true则通过
	}

	@Test
	public void testAdd() throws Exception {
		UserManager um = new UserManagerImpl();
		User u = new User();
		u.setUsername("e");
		u.setPassword("555");
		boolean exists = um.exists(u);//先判断数据库中存在不存在
		if (!exists) {//不存在就add
			um.add(u);
			u.setUsername("e");//add完再次添加相同用户，判断是否存在
			exists = um.exists(u);
			Assert.assertEquals(true, exists);//如果存在的话就表示添加成功
		} else {
			Assert.fail("user exited!");
		}
	}

}
