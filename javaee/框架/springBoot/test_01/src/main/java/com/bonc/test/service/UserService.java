package com.bonc.test.service;

import java.util.List;

import com.bonc.test.domain.UserModel;

public interface UserService {
	List<UserModel> query();
	int deleteById(int userid);
	int updateById(UserModel user);
	int add(UserModel user);
	List<UserModel> queryById(int userid);
}
