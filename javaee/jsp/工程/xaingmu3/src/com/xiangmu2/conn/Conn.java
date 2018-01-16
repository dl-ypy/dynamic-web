package com.xiangmu2.conn;
import java.sql.*;

public class Conn {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3307/ZBDX";
	public static final String DBUSER = "root";
	public static final String DBPASS = "12345678900";
	Connection conn = null;
	
	public Connection getConn()
	{
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
