package com.ypy.dao.impl;

import java.util.List;

import com.ypy.dao.IUserDao;
import com.ypy.model.UserModel;
import com.ypy.utils.DB;

public class UserDaoImpl implements IUserDao {
	String sql = "";
	@Override
	public void save(UserModel user) throws RuntimeException {
		sql = "insert into t_user (userid,username,password,truename) values(seq_t_user.nextval,?,?,?)";
		DB.DML(sql, user.getUsername(), user.getPassword(), user.getTruename());
	}

	@Override
	public void update(UserModel user) throws RuntimeException {
		sql = "update t_user set username=?,password=?,truename=? where userid = ?";
		DB.DML(sql, user.getUsername(), user.getPassword(), user.getTruename(), user.getUserid());
	}

	@Override
	public List<UserModel> query() throws RuntimeException {
		sql = "select * from t_user";
		return DB.selectAll(sql, UserModel.class);
	}

	@Override
	public UserModel queryById(int userid) throws RuntimeException {
		sql = "select * from t_user where userid = ?";
		List<UserModel> list = DB.selectAll(sql, UserModel.class, userid);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(int userid) throws RuntimeException {
		sql = "delete from t_user where userid = ?";
		DB.DML(sql, userid);
	}

}
