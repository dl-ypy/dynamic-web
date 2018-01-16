package com.xiangmu2.dao;
import com.xiangmu2.conn.Conn;//引入conn的包
import java.util.ArrayList;//引入列表的包
import java.util.List;

import java.sql.*;
import com.xiangmu2.yh.Yhgl;//引入Yhgl的包

public class UserDao {
	int rs = 0;
	Conn co = new Conn();
	Connection c = co.getConn();//用C代替jsp中的conn
	PreparedStatement pst = null;
	
	//添加用户
	public int Insert(Yhgl yh)
	{	
		try
		{
			String sql = "insert into htgl(username,password,type,phone,sex,address,youxiang)values(?,?,?,?,?,?,?)";//sql语句，这里需要在jsp页面传值
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());//给第一个问号赋值
			pst.setString(2, yh.getPassword());//给第二个问号赋值
			pst.setString(3, yh.getType());//给第三个问号赋值
			pst.setString(4, yh.getPhone());
			pst.setString(5, yh.getSex());
			pst.setString(6, yh.getAddress());
			pst.setString(7, yh.getYouxiang());
			
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//删除用户
	public int Delete(Yhgl yh)
	{	
		try
		{
			String sql = "delete from htgl where id = ?";
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getId());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//查询用户
	public List<Yhgl> Select()//返回类型为List<Yhgl>
	{
		List<Yhgl> list = new ArrayList<Yhgl>();//创建列表对象list
		
		try
		{
			String sql = "select * from htgl";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Yhgl yh = new Yhgl();
				//得到各自的值
				yh.setId(rs.getString("id"));
				yh.setUsername(rs.getString("username"));
				yh.setPassword(rs.getString("password"));
				yh.setType(rs.getString("type"));
				yh.setSex(rs.getString("sex"));
				yh.setPhone(rs.getString("phone"));
				yh.setAddress(rs.getString("address"));
				yh.setYouxiang(rs.getString("youxiang"));
				
				
				//放入列表中
				list.add(yh);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	//修改用户
	public ResultSet Select_id(Yhgl yh)
	{
		ResultSet rs = null;
		
		try
		{
			String sql = "select * from htgl where id=?";
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getId());
			rs = pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int Update(Yhgl yh)
	{
		int rs = 0;
		
		try
		{
			String sql = "update htgl set username=?,password=?,phone=?,address=?,youxiang=?,type=? where id=?";
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, yh.getPhone());
			pst.setString(4, yh.getAddress());
			pst.setString(5, yh.getYouxiang());
			pst.setString(6, yh.getType());
			pst.setString(7, yh.getId());
			rs = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//普通用户修改
	public int Updatep(Yhgl yh)
	{
		int rs = 0;
		
		try
		{
			String sql = "update htgl set username=?,password=?,phone=?,address=?,youxiang=? where id=?";
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, yh.getPhone());
			pst.setString(4, yh.getAddress());
			pst.setString(5, yh.getYouxiang());
			pst.setString(6, yh.getId());
			rs = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//注册用户时添加
	public int InsertL(Yhgl yh)
	{	
		try
		{
			String sql = "insert into htgl(username,password,type,sex,phone,youxiang,address)values(?,?,?,?,?,?,?)";//sql语句，这里需要在jsp页面传值
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, "普通用户");
			pst.setString(4, yh.getSex());
			pst.setString(5, yh.getPhone());
			pst.setString(6, yh.getYouxiang());
			pst.setString(7, yh.getAddress());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//分页中查询记录总数的方法
	public int Selectcount()
	{
		int counts = 0;
		
		try
		{
			String sql = "select count(*) from htgl";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())//  如果查询有记录，将结果集转换为int类型
			{
				counts = rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return counts;
	}
	
	//遍历每页记录的方法
	public List<Yhgl> Selectmy(int page)//这里要有参数，将页数传过来
	{
		List<Yhgl> list = new ArrayList<Yhgl>();
		
		try
		{
			String sql = "select * from htgl limit "+(page-1)*Yhgl.page_size+","+Yhgl.page_size+"";//第一个？表示从第几个记录开始查询，第二个？表示每页几条记录
			//pst.setInt(1, (page-1)*Yhgl.page_size);//这里都是int类型,直接用类名访问静态成员
			//pst.setInt(2, Yhgl.page_size);     ??????为什么赋不上值
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				Yhgl yh = new Yhgl();
				yh.setId(rs.getString("id"));
				yh.setUsername(rs.getString("username"));
				yh.setPassword(rs.getString("password"));
				yh.setType(rs.getString("type"));
				yh.setSex(rs.getString("sex"));
				yh.setPhone(rs.getString("phone"));
				yh.setAddress(rs.getString("address"));
				yh.setYouxiang(rs.getString("youxiang"));
				list.add(yh);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//判断是否能登陆     根据登陆填的信息查询数据库是否有记录
	public int Panduan(Yhgl yh)
	{
		int count = 0;
		
		try
		{
			String sql = "select * from htgl where username=? and password=? and type=?";
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, yh.getType());
			ResultSet rs = pst.executeQuery();
			
			rs.last();
			return count = rs.getRow();//返回行数，但上面那句话不能省略
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
}
