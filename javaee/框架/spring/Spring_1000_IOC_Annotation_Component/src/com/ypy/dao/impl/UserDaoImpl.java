package com.ypy.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao的实现
 */

@Component    //能通过@Component("名字")来指定名字，这时就需要通过@Resource(name="名字")来调用
public class UserDaoImpl implements UserDao{
	@Override
	public void save(User u) {
		System.out.println("saved!");
	}
}
