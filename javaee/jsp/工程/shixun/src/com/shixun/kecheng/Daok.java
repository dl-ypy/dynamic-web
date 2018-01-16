package com.shixun.kecheng;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shixun.chengji.Yhc;
import com.shixun.conn.Conn;
import com.shixun.student.*;

public class Daok {
	Conn c = new Conn();
	Connection conn = c.getConn();
	PreparedStatement pst = null;
	//选课
	public int Xuanke(Yhs yhs, Yhc yhc)
	{
		int rs = 0;
		try
		{
			String xuanke = "update student as S inner join chengji as C on S.st_id=C.st_id set C.cj=null,S.kc_id=?,S.th_id=?,C.kc_id=? where S.st_id=?";
			pst = conn.prepareStatement(xuanke);
			pst.setString(1, yhs.getKc_id());
			pst.setString(2, yhs.getTh_id());
			pst.setString(3, yhc.getKc_id());
			pst.setString(4, yhs.getSt_id());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	//退课
	public int Tuike(Yhs yhs)
	{
		int rs = 0;
		try
		{
			String xuanke = "update student as S inner join chengji as C on S.st_id=C.st_id set S.kc_id=null,S.th_id=null,C.cj=null where S.st_id=?";
			//多表更新
			pst = conn.prepareStatement(xuanke);
			pst.setString(1, yhs.getSt_id());
			rs = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	//查询课程名称、教师名称
	public ResultSet Selectcx()
	{
		ResultSet rs = null;
		try
		{
			String selectcx = "select K.kc_id,K.kc_name,T.th_name from kecheng as K join teacher as T on K.th_id=T.th_id";
			pst = conn.prepareStatement(selectcx);
			rs = pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	//查询选课人数
	public ResultSet Selectrs(Yhs yhs)
	{
		ResultSet rs = null;
		try
		{
			String selectcx = "select count(*) from student where kc_id=?";
			pst = conn.prepareStatement(selectcx);
			pst.setString(1, yhs.getKc_id());
			rs = pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	//添加
	public int InsertKc(Yhk kc){
		int rs=0;
		try{
		   String sql="insert into kecheng(kc_name,kc_address,th_id) values(?,?,?)";
		   PreparedStatement pst=conn.prepareStatement(sql);
		   pst.setString(1,kc.getKc_name());
		   pst.setString(2,kc.getKc_address());
		   pst.setString(3, kc.getTh_id());
		   
		   rs = pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;	
		}

	//查询总记录数
		public int Selectcount()
		{
			int count = 0;
			try
			{
				String selectcount = "select count(*) from kecheng";
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
		//管理员分页查询
		public List<Yhk> SelectKc(int page){
			List<Yhk> list=new ArrayList<Yhk>();
			ResultSet rs=null;
		    try{
		    	String select = "select * from kecheng limit ?,?";
				pst = conn.prepareStatement(select);
				pst.setInt(1, (page-1)*Yhk.page_size);
				pst.setInt(2, Yhk.page_size);
		        rs=pst.executeQuery();
		        while(rs.next()){
		          Yhk kc=new Yhk();
		          kc.setKc_id(rs.getString("kc_id"));
		          kc.setKc_name(rs.getString("kc_name"));
		          kc.setKc_address(rs.getString("kc_address"));
		          kc.setTh_id(rs.getString("th_id"));
		          list.add(kc);	
		         }
		       }
		    catch(Exception e){
			e.printStackTrace();
		    }
		    return list;	
		    }
		
		//管理员修改 
		public ResultSet SelectKcId(Yhk kc){
			ResultSet rs=null;
			try{
			String sql_select_id="select * from kecheng where kc_id=?";
			PreparedStatement pst=conn.prepareStatement(sql_select_id);
			pst.setString(1, kc.getKc_id());
			rs=pst.executeQuery();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		} 
		public int UpdateKcId(Yhk kc, Yhs yhs){
			int rs=0;
			try{
			String sql_update_kc="update kecheng as K inner join student as S on K.kc_id=S.kc_id set K.kc_name=?,K.kc_address=?,K.th_id=?,S.th_id=? where K.kc_id=?";
			PreparedStatement pst=conn.prepareStatement(sql_update_kc);
			
			pst.setString(1, kc.getKc_name());
			pst.setString(2, kc.getKc_address());
			pst.setString(3, kc.getTh_id());
			pst.setString(4, yhs.getTh_id());
			pst.setString(5, kc.getKc_id());
			
			rs=pst.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		}
		
		
		//删除
		public int DeleteKc(Yhk kc){
			int rs=0;
			try{
			String sql_update_kc="delete from kecheng where kc_id=?";
			PreparedStatement pst=conn.prepareStatement(sql_update_kc);
			pst.setString(1, kc.getKc_id());
			rs=pst.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		} 
		
		//普通教师查询课程信息
		public ResultSet SelectKcpt(Yhk kc){
			ResultSet rs=null;
			try{
			String sql_select_id="select * from kecheng where th_id=?";
			PreparedStatement pst=conn.prepareStatement(sql_select_id);
			pst.setString(1, kc.getTh_id());
			rs=pst.executeQuery();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		} 
}
