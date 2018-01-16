package com.ypy.registeration.useraction;

import org.junit.Assert;
import org.junit.Test;

import com.ypy.registeration.action.UserAction;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("aa");
		ua.setPassword("aa");
		String ret = ua.execute();
		Assert.assertEquals("success", ret);
	}

}
