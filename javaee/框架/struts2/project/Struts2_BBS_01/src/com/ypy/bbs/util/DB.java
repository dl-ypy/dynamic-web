package com.ypy.bbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	public static Connection createConn(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bbs", "root", "12345678900");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement prepare(Connection conn, String sql){
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ps;
	}
	
	public static void close(Connection conn){
		if (null == conn) return;
		try{
			conn.close();
			conn = null;//设为null，垃圾回收器就能马上回收
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		if (null == stmt) return;
		try{
			stmt.close();
			stmt = null;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		if (null == rs) return;
		try{
			rs.close();
			rs = null;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}














