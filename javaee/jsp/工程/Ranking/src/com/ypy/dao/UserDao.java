package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ypy.conn.Conn;
import com.ypy.model.User;
/**
 * 关于普通用户数据的操作
 * @author ypy
 */
public class UserDao {
	private Connection conn = Conn.getConn();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql;
	private int count = 0;
	
	/**
	 * 分页查询用户
	 * @param currentpage 当前页数
	 * @return 封装所查询到用户的List集合
	 */
	public List<User> userSelect(int currentpage) {
		List<User> list = new ArrayList<User>();
		sql = "select * from user limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentpage-1)*User.PAGE_SIZE);//从第几条记录开始
			ps.setInt(2, User.PAGE_SIZE);//每页几条记录
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setSecurity(rs.getString("security"));
				user.setAnswer(rs.getString("answer"));
				user.setEmail(rs.getString("email"));
				user.setHobby(rs.getString("hobby"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 删除指定用户
	 * @param id 所删除用户的id
	 * @return 数据库执行删除后返回的操作数值，如果不等于0，则删除成功，否则，删除失败
	 */
	public int userRemove(int id) {
		sql = "delete from user where id = '"+ id +"'";
		try {
			ps = conn.prepareStatement(sql);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 按用户名和密码查找用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 查找到的集合
	 */
	public ResultSet selectByUsernameAndPassword(String username, String password) {
		sql = "select * from user where username = "+username+" and password = "+password;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 按用id查找用户
	 * @param id 用户id
	 * @return 查找到的集合
	 */
	public ResultSet selectById(int id) {
		sql = "select * from user where id = "+id;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 修改用户信息
	 * @param user 用户类
	 * @return
	 */
	public int userUpdate(User user) {
		sql = "update user set username=?,password=?,phone=?,answer=?,email=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getAnswer());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
