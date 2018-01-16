package com.ypy.service;

import java.util.List;

import com.ypy.model.UserModel;

public interface IUserService {
	void save(UserModel user) throws RuntimeException;
	void update(UserModel user) throws RuntimeException;
	List<UserModel> query() throws RuntimeException;
	UserModel queryById(int userid) throws RuntimeException;
	void delete(int userid) throws RuntimeException;
}
