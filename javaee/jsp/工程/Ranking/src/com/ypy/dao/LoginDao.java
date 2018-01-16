package com.ypy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ypy.conn.Conn;
/**
 * �û������Ա��¼ʱ����dao��
 * @author ypy
 */
public class LoginDao {
	private Connection conn = Conn.getConn();
	private PreparedStatement ps = null; 
	private int count = 0;
	private ResultSet rs = null;
	
	/**
	 * ��¼ʱ�ж��û�(�����Ա)�Ƿ����
	 * @param username �û���
	 * @param password �û�����
	 * @param status �û�����ݣ��ж��ǹ���Ա������ͨ�û�
	 * @return Boolean���͵�ֵ��true��ʾ�û����ڣ�false��ʾ�û�������
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
