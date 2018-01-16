package com.bonc.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bonc.test.domain.UserModel;
import com.bonc.test.mapper.UserMapper;
import com.bonc.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserModel> query() {
		return userMapper.query();
	}

	@Override
	public int deleteById(int userid) {
		return userMapper.deleteById(userid);
	}

	@Override
	public int updateById(UserModel user) {
		return userMapper.updateById(user);
	}

	@Override
	public int add(UserModel user) {
		return userMapper.add(user);
	}

	@Override
	public List<UserModel> queryById(int userid) {
		return userMapper.queryById(userid);
	}

}
