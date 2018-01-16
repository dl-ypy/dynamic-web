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
 * ���ڹ���Ա���ݵĲ���
 * @author ypy
 */
public class AdministratorDao {
	Connection conn = Conn.getConn();
	PreparedStatement ps = null;
	int count = 0;
	ResultSet rs = null;
	
	/**
	 * ��ҳ��ѯ���й���Ա��Ϣ
	 * @param currentpage ��ǰҳ��
	 * @return ��װ����ѯ������Ա��List����
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
	 * ��ӹ���Ա
	 * @param admin ����Ա��
	 * @return ��ӹ���Ա�����ݿⷵ�صĲ����������������0˵����ӳɹ�������0�����ʧ��
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
