package com.xiangmu2.zhuce;
import java.sql.*;

import com.xiangmu2.conn.*;
import com.xiangmu2.zhuce.Yhgl;

public class Dao {
	int rs = 0;
	
	public int Insert(Yhgl yh)
	{	
		try
		{
			Conn co = new Conn();
			Connection c = co.getConn();
			String sql = "insert into yh(username,password,type)values(?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, yh.getType());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}
