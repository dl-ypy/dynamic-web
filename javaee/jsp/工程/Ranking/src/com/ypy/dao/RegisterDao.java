package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ypy.conn.Conn;
import com.ypy.model.User;
/**
 * �û�ע��ʱ��dao��
 * @author ypy
 */
public class RegisterDao {
	Connection conn = Conn.getConn();
	PreparedStatement ps = null;
	int count = 0;
	ResultSet rs = null;
	
	/**
	 * �ж���ע����û�������ӵĹ���Ա���Ƿ����
	 * @param username �û���
	 * @param status �û����
	 * @return Boolean���͵�ֵ��true��ʾ��ע����û����Ѿ���ע�ᣬfalse��ʾ��ע����û���û��ע��
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
	 * ע���û�
	 * @param user �û���
	 * @return ����û������ݿⷵ�صĲ����������������0˵����ӳɹ�������0�����ʧ��
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
