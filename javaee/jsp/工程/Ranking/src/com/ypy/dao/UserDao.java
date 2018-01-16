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
 * ������ͨ�û����ݵĲ���
 * @author ypy
 */
public class UserDao {
	private Connection conn = Conn.getConn();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql;
	private int count = 0;
	
	/**
	 * ��ҳ��ѯ�û�
	 * @param currentpage ��ǰҳ��
	 * @return ��װ����ѯ���û���List����
	 */
	public List<User> userSelect(int currentpage) {
		List<User> list = new ArrayList<User>();
		sql = "select * from user limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentpage-1)*User.PAGE_SIZE);//�ӵڼ�����¼��ʼ
			ps.setInt(2, User.PAGE_SIZE);//ÿҳ������¼
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
	 * ɾ��ָ���û�
	 * @param id ��ɾ���û���id
	 * @return ���ݿ�ִ��ɾ���󷵻صĲ�����ֵ�����������0����ɾ���ɹ�������ɾ��ʧ��
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
	 * ���û�������������û�
	 * @param username �û���
	 * @param password ����
	 * @return ���ҵ��ļ���
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
	 * ����id�����û�
	 * @param id �û�id
	 * @return ���ҵ��ļ���
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
	 * �޸��û���Ϣ
	 * @param user �û���
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
