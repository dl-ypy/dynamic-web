package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ypy.conn.Conn;
import com.ypy.model.Administrator;

/**
 * 关于管理员数据的操作
 * @author ypy
 */
public class AdministratorDao {
	Connection conn = Conn.getConn();
	PreparedStatement ps = null;
	int count = 0;
	ResultSet rs = null;
	
	/**
	 * 分页查询所有管理员信息
	 * @param currentpage 当前页数
	 * @return 封装所查询到管理员的List集合
	 */
	public List<Administrator> adminList(int currentpage) {
		List<Administrator> list = new ArrayList<Administrator>();
		String sql = "select * from admin limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentpage-1)*Administrator.PAGE_SIZE);
			ps.setInt(2, Administrator.PAGE_SIZE);
			rs = ps.executeQuery();
			while (rs.next()) {
				Administrator admin = new Administrator();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 添加管理员
	 * @param admin 管理员类
	 * @return 添加管理员后数据库返回的操作数，如果不等于0说明添加成功，等于0则添加失败
	 */
	public int adminAdd(Administrator admin) {
		String sql = "insert into admin (username,password) values (?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
