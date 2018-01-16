package com.shixun.teacher;
import java.util.*;

import com.shixun.conn.*;

import java.sql.*;

public class Dao {
	Conn c = new Conn();
	Connection conn = c.getConn();
	PreparedStatement pst = null;
	
	//����Ա��ҳ��ѯ
	public List<Yh> Select(int page)
	{
		List<Yh> list = new ArrayList<Yh>();
		
		try
		{
			String select = "select * from teacher limit ?,?";
			pst = conn.prepareStatement(select);
			pst.setInt(1, (page-1)*Yh.page_size);
			pst.setInt(2, Yh.page_size);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				Yh yh = new Yh();
				yh.setTh_id(rs.getString("th_id"));
				yh.setTh_name(rs.getString("th_name"));
				yh.setTh_sex(rs.getString("th_sex"));
				yh.setTh_type(rs.getString("th_type"));
				yh.setTh_phone(rs.getString("th_phone"));
				yh.setTh_zhiwei(rs.getString("th_zhiwei"));
				list.add(yh);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	//��ѯ�ܼ�¼��
	public int Selectcount()
	{
		int count = 0;
		try
		{
			String selectcount = "select count(*) from teacher";
			pst = conn.prepareStatement(selectcount);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//ע�����
	public int insert(Yh yh)
	{
		int rs = 0;
		try
		{
			String insert = "insert into teacher (th_name,th_password,th_type,th_sex,th_zhiwei)values(?,'000000',?,?,?)";
			pst = conn.prepareStatement(insert);
			pst.setString(1, yh.getTh_name());
			pst.setString(2, yh.getTh_type());
			pst.setString(3, yh.getTh_sex());
			pst.setString(4, yh.getTh_zhiwei());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	//�޸�
	public ResultSet Selectid(Yh yh)
	{
		ResultSet rs = null;
		try
		{
			String selectid = "select * from teacher where th_id=?";
			pst = conn.prepareStatement(selectid);
			pst.setString(1, yh.getTh_id());
			rs = pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	//��ͨ��ʦ�޸ĸ�����Ϣ
	public int update(Yh yh)
	{
		int rs = 0;
		try
		{
			String insert = "update teacher set th_name=?,th_password=?,th_sex=?,th_phone=? where th_id=?";
			pst = conn.prepareStatement(insert);
			pst.setString(1, yh.getTh_name());
			pst.setString(2, yh.getTh_password());
			pst.setString(3, yh.getTh_sex());
			pst.setString(4, yh.getTh_phone());
			pst.setString(5, yh.getTh_id());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	//����Ա�޸�
	public int updateg(Yh yh)
	{
		int rs = 0;
		try
		{
			String insert = "update teacher set th_type=? where th_id=?";
			pst = conn.prepareStatement(insert);
			pst.setString(1, yh.getTh_type());
			pst.setString(2, yh.getTh_id());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	//ɾ��
	public int Delete(Yh yh)
	{
		int rs = 0;
		try
		{
			String delete = "delete from teacher where th_id=?";
			pst = conn.prepareStatement(delete);
			pst.setString(1, yh.getTh_id());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	//�ж��Ƿ��ܵ�½     ���ݵ�½�����Ϣ��ѯ���ݿ��Ƿ��м�¼
		public ResultSet Panduan(Yh yh)
		{	
			ResultSet rs = null;
			
			try
			{
				String sql = "select * from teacher where th_id=? and th_password=? and th_type=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, yh.getTh_id());
				pst.setString(2, yh.getTh_password());
				pst.setString(3, yh.getTh_type());
				rs = pst.executeQuery();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return rs;
		}
}
