package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ypy.conn.Conn;
import com.ypy.model.User;
/**
 * 用户注册时的dao层
 * @author ypy
 */
public class RegisterDao {
	Connection conn = Conn.getConn();
	PreparedStatement ps = null;
	int count = 0;
	ResultSet rs = null;
	
	/**
	 * 判断所注册的用户（所添加的管理员）是否存在
	 * @param username 用户名
	 * @param status 用户身份
	 * @return Boolean类型的值，true表示所注册的用户名已经被注册，false表示所注册的用户名没被注册
	 */
	public boolean userExist(String username, String status) {
		String sql = null;
		if ("user".equals(status)) {
			sql = "select count(*) from user where username = '"+username+"'";
		} else if ("admin".equals(status)) {
			sql = "select count(*) from admin where username = '"+username+"'";
		} else {
			sql = null;
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
				if (count > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 注册用户
	 * @param user 用户类
	 * @return 添加用户后数据库返回的操作数，如果不等于0说明添加成功，等于0则添加失败
	 */
	public int userRegister(User user) {
		String sql = "insert into user (username,password,sex,phone,security,answer,email,hobby) values (?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getSecurity());
			ps.setString(6, user.getAnswer());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getHobby());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
