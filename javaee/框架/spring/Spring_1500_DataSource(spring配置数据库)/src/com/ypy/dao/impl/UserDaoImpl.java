package com.ypy.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.ypy.dao.UserDao;
import com.ypy.model.User;

/**
 * UserDao的实现
 */

@Component    //能通过@Component("名字")来指定名字，这时就需要通过@Resource(name="名字")来调用
public class UserDaoImpl implements UserDao{
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource       //这个一定要记得配置
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
