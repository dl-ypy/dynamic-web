package com.xiangmu2.dao;
import com.xiangmu2.conn.Conn;//����conn�İ�
import java.util.ArrayList;//�����б�İ�
import java.util.List;

import java.sql.*;
import com.xiangmu2.yh.Yhgl;//����Yhgl�İ�

public class UserDao {
	int rs = 0;
	Conn co = new Conn();
	Connection c = co.getConn();//��C����jsp�е�conn
	PreparedStatement pst = null;
	
	//����û�
	public int Insert(Yhgl yh)
	{	
		try
		{
			String sql = "insert into htgl(username,password,type,phone,sex,address,youxiang)values(?,?,?,?,?,?,?)";//sql��䣬������Ҫ��jspҳ�洫ֵ
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());//����һ���ʺŸ�ֵ
			pst.setString(2, yh.getPassword());//���ڶ����ʺŸ�ֵ
			pst.setString(3, yh.getType());//���������ʺŸ�ֵ
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
	
	//ɾ���û�
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
	
	//��ѯ�û�
	public List<Yhgl> Select()//��������ΪList<Yhgl>
	{
		List<Yhgl> list = new ArrayList<Yhgl>();//�����б����list
		
		try
		{
			String sql = "select * from htgl";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Yhgl yh = new Yhgl();
				//�õ����Ե�ֵ
				yh.setId(rs.getString("id"));
				yh.setUsername(rs.getString("username"));
				yh.setPassword(rs.getString("password"));
				yh.setType(rs.getString("type"));
				yh.setSex(rs.getString("sex"));
				yh.setPhone(rs.getString("phone"));
				yh.setAddress(rs.getString("address"));
				yh.setYouxiang(rs.getString("youxiang"));
				
				
				//�����б���
				list.add(yh);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	//�޸��û�
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
	
	//��ͨ�û��޸�
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
	
	//ע���û�ʱ���
	public int InsertL(Yhgl yh)
	{	
		try
		{
			String sql = "insert into htgl(username,password,type,sex,phone,youxiang,address)values(?,?,?,?,?,?,?)";//sql��䣬������Ҫ��jspҳ�洫ֵ
			pst = c.prepareStatement(sql);
			pst.setString(1, yh.getUsername());
			pst.setString(2, yh.getPassword());
			pst.setString(3, "��ͨ�û�");
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
	
	//��ҳ�в�ѯ��¼�����ķ���
	public int Selectcount()
	{
		int counts = 0;
		
		try
		{
			String sql = "select count(*) from htgl";
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())//  �����ѯ�м�¼���������ת��Ϊint����
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
	
	//����ÿҳ��¼�ķ���
	public List<Yhgl> Selectmy(int page)//����Ҫ�в�������ҳ��������
	{
		List<Yhgl> list = new ArrayList<Yhgl>();
		
		try
		{
			String sql = "select * from htgl limit "+(page-1)*Yhgl.page_size+","+Yhgl.page_size+"";//��һ������ʾ�ӵڼ�����¼��ʼ��ѯ���ڶ�������ʾÿҳ������¼
			//pst.setInt(1, (page-1)*Yhgl.page_size);//���ﶼ��int����,ֱ�����������ʾ�̬��Ա
			//pst.setInt(2, Yhgl.page_size);     ??????Ϊʲô������ֵ
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
	
	
	//�ж��Ƿ��ܵ�½     ���ݵ�½�����Ϣ��ѯ���ݿ��Ƿ��м�¼
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
			return count = rs.getRow();//�����������������Ǿ仰����ʡ��
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
}
