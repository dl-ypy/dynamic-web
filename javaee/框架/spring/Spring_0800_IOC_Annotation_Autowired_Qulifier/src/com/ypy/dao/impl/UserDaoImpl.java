package com.ypy.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDaoµÄÊµÏÖ
 */
public class UserDaoImpl implements UserDao{
	private int daoId;
	
	public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}

	@Override
	public void save(User u) {
		System.out.println("saved!");
	}

		@Override
	public String toString() {
		return "daoId=" + daoId;
	}
	
}
