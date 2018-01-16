package com.ypy.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao��ʵ��
 */

@Component    //��ͨ��@Component("����")��ָ�����֣���ʱ����Ҫͨ��@Resource(name="����")������
public class UserDaoImpl implements UserDao{
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource       //���һ��Ҫ�ǵ�����
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(User u) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			conn.createStatement().executeUpdate("insert into user values(null, 'ypy')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("saved!");
	}
}
