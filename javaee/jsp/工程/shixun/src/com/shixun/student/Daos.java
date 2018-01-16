package com.shixun.student;

import java.sql.*;
import java.util.*;

import com.shixun.chengji.Yhc;
import com.shixun.conn.Conn;
public class Daos {
	Conn c = new Conn();
	Connection conn = c.getConn();
	PreparedStatement pst = null;
	
	//注册添加
	//学生表插入
	public int Insert(Yhs stu){
        int rs=0;
        try{
            String insert_student="insert into student(st_name,st_sex,st_password,st_banji,st_xi,st_id) value(?,?,'000000',?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insert_student);
            ps.setString(1,stu.getSt_name());
            ps.setString(2,stu.getSt_sex());
            ps.setString(3,stu.getSt_banji());
            ps.setString(4,stu.getSt_xi());
            ps.setString(5,stu.getSt_id());
            rs=ps.executeUpdate();
            }
        catch(Exception e){
                            e.printStackTrace();
                            }
        return rs;
        }
	//成绩表插入
		public int Insertcj(Yhc yhc){
	        int rs=0;
	        try{
	            String insert_student="insert into chengji(st_id,xuenian,xueqi) value(?,?,?)";
	            PreparedStatement ps=conn.prepareStatement(insert_student);
	            ps.setString(1,yhc.getSt_id());
	            ps.setString(2,yhc.getXuenian());
	            ps.setString(3,yhc.getXueqi());
	            rs=ps.executeUpdate();
	            }
	        catch(Exception e){
	                            e.printStackTrace();
	                            }
	        return rs;
	        }

	//管理员查询
	public List<Yhs> Select(int page){
       List<Yhs> list=new ArrayList<Yhs>();
       ResultSet rs=null;
       try{
    	   String select = "select * from student limit ?,?";
			pst = conn.prepareStatement(select);
			pst.setInt(1, (page-1)*Yhs.page_size);
			pst.setInt(2, Yhs.page_size);
           rs=pst.executeQuery();
           while(rs.next()){
                Yhs stu=new Yhs();
                stu.setSt_id(rs.getString("st_id"));
                stu.setSt_name(rs.getString("st_name"));
                stu.setSt_phone(rs.getString("st_phone"));
                stu.setSt_xi(rs.getString("st_xi"));
                stu.setSt_sex(rs.getString("st_sex"));
                stu.setSt_banji(rs.getString("st_banji"));
                stu.setKc_id(rs.getString("kc_id"));
                stu.setTh_id(rs.getString("th_id"));
                list.add(stu);
                }
           }
        catch(Exception e){
	           e.printStackTrace();
	           }

         return list;
         }

	//修改
	public ResultSet SelectId(Yhs stu){
        ResultSet rs=null;
        try{
            String sql_id="select * from student where st_id=?";
            PreparedStatement ps=conn.prepareStatement(sql_id);
            ps.setString(1,stu.getSt_id());
            rs=ps.executeQuery();
            }
         catch(Exception e){
                e.printStackTrace();
                }
         return rs;
        }
	//管理员修改
	public int Update(Yhs stu){
        int rs=0;
        try{
            String sql_update="update student set st_banji=?,st_xi=? where st_id=?";
            PreparedStatement ps=conn.prepareStatement(sql_update);
            ps.setString(1, stu.getSt_banji());
            ps.setString(2, stu.getSt_xi());
            ps.setString(3, stu.getSt_id());
            rs=ps.executeUpdate();
            }
         catch(Exception e){
                e.printStackTrace();
               }
          return rs;
         }

	
	//删除
	//先删除成绩表中的
	public int Deletecj(Yhc stu){
	      int rs=0;
	      try{
	          String Sql_delete="delete from chengji where st_id=?";
	          PreparedStatement ps=conn.prepareStatement(Sql_delete);
	          ps.setString(1, stu.getSt_id());
	          rs=ps.executeUpdate();
	          }
	       catch(Exception e){
                e.printStackTrace();
                }
	       return rs;
	       }
	//再删除学生表中的
	public int Delete(Yhs stu){
	      int rs=0;
	      try{
	          String Sql_delete="delete from student where st_id=?";
	          PreparedStatement ps=conn.prepareStatement(Sql_delete);
	          ps.setString(1, stu.getSt_id());
	          rs=ps.executeUpdate();
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
					String selectcount = "select count(*) from student";
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
			
			//教师查询单个学生信息
			public ResultSet Selectpxs(Yhs yhs)
			{
				ResultSet rs = null;
				try
				{
					String selectxs = "select * from student where th_id=?";
					pst = conn.prepareStatement(selectxs);
					pst.setString(1, yhs.getTh_id());
					rs = pst.executeQuery();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return rs;
			}
			
			//修改单个学生信息
			public int Updatexs(Yhs stu){
		        int rs=0;
		        try{
		            String sql_update="update student set st_name=?,st_password=?,st_sex=?,st_phone=? where st_id=?";
		            PreparedStatement ps=conn.prepareStatement(sql_update);
		            ps.setString(1, stu.getSt_name());
		            ps.setString(2, stu.getSt_password());
		            ps.setString(3,stu.getSt_sex());
		            ps.setString(4,stu.getSt_phone());
		            ps.setString(5, stu.getSt_id());
		            rs=ps.executeUpdate();
		            }
		         catch(Exception e){
		                e.printStackTrace();
		               }
		          return rs;
		         }
			
			//学生查询
			public ResultSet Selectxs(Yhs yhs)
			{
				ResultSet rs = null;
				try
				{
					String selectxs = "select * from student where st_id=?";
					pst = conn.prepareStatement(selectxs);
					pst.setString(1, yhs.getSt_id());
					rs = pst.executeQuery();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return rs;
			}
			
			//普通教师查询
			public ResultSet Selectpt(Yhs yhs)
			{
				ResultSet rs = null;
				try
				{
					String selectpt = "select S.st_id,S.st_name,K.kc_name,S.st_sex,S.st_phone,S.st_banji,S.st_xi,C.cj,C.xuenian,C.xueqi from student as S join chengji as C on S.st_id=C.st_id join kecheng as K on K.kc_id=S.kc_id  where S.th_id=?";
					pst = conn.prepareStatement(selectpt);
					pst.setString(1, yhs.getTh_id());
					rs = pst.executeQuery();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return rs;
			}
			
			//普通教师修改
			public ResultSet selectid(Yhc yhc)
			{
				ResultSet rs = null;
				try
				{
					String selectpt = "select * from chengji where st_id=?";
					pst = conn.prepareStatement(selectpt);
					pst.setString(1, yhc.getSt_id());
					rs = pst.executeQuery();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return rs;
			}
			public int updatept(Yhc yhc)
			{
				int rs = 0;
				try
				{
					String selectpt = "update chengji set cj=? where st_id=?";
					pst = conn.prepareStatement(selectpt);
					pst.setString(1, yhc.getCj());
					pst.setString(2, yhc.getSt_id());
					rs = pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return rs;
			}
			
			//判断是否能登陆     根据登陆填的信息查询数据库是否有记录
			public ResultSet Panduan(Yhs yhs)
			{	
				ResultSet rs = null;
				
				try
				{
					String sql = "select * from student where st_id=? and st_password=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, yhs.getSt_id());
					pst.setString(2, yhs.getSt_password());
					rs = pst.executeQuery();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return rs;
			}
}
