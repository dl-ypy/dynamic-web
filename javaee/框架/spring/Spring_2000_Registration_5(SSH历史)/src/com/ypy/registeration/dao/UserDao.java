package com.ypy.registeration.dao;

import com.ypy.registeration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean CheckUserExistsWithName(String username);
}
