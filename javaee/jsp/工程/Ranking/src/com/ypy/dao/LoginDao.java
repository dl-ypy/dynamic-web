package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ypy.conn.Conn;
/**
 * 用户或管理员登录时所需dao层
 * @author ypy
 */
public class LoginDao {
	private Connection conn = Conn.getConn();
	private PreparedStatement ps = null; 
	private int count = 0;
	private ResultSet rs = null;
	
	/**
	 * 登录时判断用户(或管理员)是否存在
	 * @param username 用户名
	 * @param password 用户密码
	 * @param status 用户的身份，判断是管理员还是普通用户
	 * @return Boolean类型的值，true表示用户存在，false表示用户不存在
	 */
	public boolean userExist(String username, String password, String status) {
		String sql = null;
		if ("user".equals(status)) {
			sql = "select count(*) from user where username = '"+username+"' and password = '"+password+"'";
		} else if ("admin".equals(status)) {
			sql = "select count(*) from admin where username = '"+username+"' and password = '"+password+"'";
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
}
