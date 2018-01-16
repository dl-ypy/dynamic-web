package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ypy.conn.Conn;
/**
 * 分页时的dao层
 * @author ypy
 */
public class PagingDao {
	private Connection conn = Conn.getConn();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	/**
	 * 得到总记录数
	 * @param status 用户的身份
	 * @return 总记录数
	 */
	public int getAllRecords(String status) {
		int count = 0;
		String sql = null;
		if ("user".equals(status)) {
			sql = "select count(*) from user";
		} else if ("admin".equals(status)) {
			sql = "select count(*) from admin";
		} else {
			sql = null;
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
