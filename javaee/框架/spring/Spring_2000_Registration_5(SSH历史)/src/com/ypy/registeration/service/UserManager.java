package com.ypy.registeration.service;

import com.ypy.registeration.model.User;

public interface UserManager {

	boolean exists(User u);

	void add(User u) throws Exception;

}