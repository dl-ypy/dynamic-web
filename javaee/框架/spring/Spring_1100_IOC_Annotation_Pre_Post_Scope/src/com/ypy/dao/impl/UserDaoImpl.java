package com.ypy.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao��ʵ��
 */

@Component    //��ͨ��@Component("����")��ָ�����֣���ʱ����Ҫͨ��@Resource(name="����")������
public class UserDaoImpl implements UserDao{
	@Override
	public void save(User u) {
		System.out.println("saved!");
	}
}
