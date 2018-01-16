package com.shixun.chengji;
import com.shixun.conn.*;

import java.sql.*;

public class Daoc {
	Conn c = new Conn();
	Connection conn = c.getConn();
	PreparedStatement pst = null;
	//��ѯ�ܼ�¼��
			public int Selectcount()
			{
				int count = 0;
				try
				{
					String selectcount = "select count(*) from chengji";
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
	
	//����Ա��ѯ
		public ResultSet Select(int page){
	       ResultSet rs=null;
	       try{
	    	   String select = "select S.st_banji,S.st_id,K.kc_id,C.cj_id,C.xuenian,C.xueqi,S.st_name,K.kc_name,T.th_name,C.cj from chengji as C join student as S on S.st_id=C.st_id join kecheng as K on K.kc_id=C.kc_id join teacher as T on T.th_id=K.th_id limit ?,?";
				pst = conn.prepareStatement(select);
				pst.setInt(1, (page-1)*Yhc.page_size);
				pst.setInt(2, Yhc.page_size);
	           rs=pst.executeQuery();
	           }
	        catch(Exception e){
		           e.printStackTrace();
		           }

	         return rs;
	         }
		
		//¼��/�޸�ѧ���ɼ�
		public ResultSet Selectcjid(Yhc yhc)
		{
			ResultSet rs = null;
			try
			{
				String selectcjid = "select * from chengji where st_id=? and kc_id=?";
				pst = conn.prepareStatement(selectcjid);
				pst.setString(1, yhc.getSt_id());
				pst.setString(2, yhc.getKc_id());
				rs = pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();			}
			return rs;
		}
		public int updatacj(Yhc yhc)
		{
			int rs = 0;
			try
			{
				String updatacj = "update chengji set cj=? where st_id=? and kc_id=?";
				pst = conn.prepareStatement(updatacj);
				pst.setString(1, yhc.getCj());
				pst.setString(2, yhc.getSt_id());
				pst.setString(3, yhc.getKc_id());
				rs = pst.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		
		//���༶��ѯ
		public ResultSet Selectanxs(Yhc yhc)
		{
			ResultSet rs = null;
			try
			{
				String selectcj = "select S.st_banji,S.st_id,S.st_name,K.kc_name,T.th_name,C.cj from chengji as C join student as S on S.st_id=C.st_id join kecheng as K on K.kc_id=C.kc_id join teacher as T on T.th_id=K.th_id where S.st_banji=? order by C.cj desc";
				pst = conn.prepareStatement(selectcj);
				pst.setString(1, yhc.getSt_banji());
				rs = pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		//�鿴�༶�������
		public ResultSet Selectanxszt(Yhc yhc)
		{
			ResultSet rs = null;
			try
			{
				String selectcj = "select sum(C.cj),avg(C.cj),min(C.cj),max(C.cj) from chengji as C join student as S on S.st_id=C.st_id where S.st_banji=?";
				pst = conn.prepareStatement(selectcj);
				pst.setString(1, yhc.getSt_banji());
				rs = pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}

		//���γ̲�ѯ
		public ResultSet Selectankc(Yhc yhc)
		{
			ResultSet rs = null;
			try
			{
				String selectcj = "select K.kc_id,S.st_id,S.st_name,K.kc_name,T.th_name,C.cj from chengji as C join student as S on S.st_id=C.st_id join kecheng as K on K.kc_id=C.kc_id join teacher as T on T.th_id=K.th_id where K.kc_id=? order by C.cj desc";
				pst = conn.prepareStatement(selectcj);
				pst.setString(1, yhc.getKc_id());
				rs = pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		//�鿴�γ��������
		public ResultSet Selectankczt(Yhc yhc)
		{
			ResultSet rs = null;
			try
			{
				String selectcj = "select sum(cj),avg(cj),min(cj),max(cj) from chengji where kc_id=?";
				pst = conn.prepareStatement(selectcj);
				pst.setString(1, yhc.getKc_id());
				rs = pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		
		//ѧ����ѯ�ɼ�
		public ResultSet Selectxs(Yhc yhc){
	       ResultSet rs=null;
	       try{
	    	   String select = "select S.st_banji,S.st_id,K.kc_id,C.cj_id,C.xuenian,C.xueqi,S.st_name,K.kc_name,T.th_name,C.cj from chengji as C join student as S on S.st_id=C.st_id join kecheng as K on K.kc_id=C.kc_id join teacher as T on T.th_id=K.th_id where S.st_id=? and K.kc_id=?";
				pst = conn.prepareStatement(select);
				pst.setString(1, yhc.getSt_id());
				pst.setString(2, yhc.getKc_id());
	           rs=pst.executeQuery();
	           }
	        catch(Exception e){
		           e.printStackTrace();
		           }

	         return rs;
	         }
}
