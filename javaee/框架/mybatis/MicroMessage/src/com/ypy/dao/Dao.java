package com.ypy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ypy.bean.Command;
import com.ypy.bean.Message;
import com.ypy.db.DBAccess;
import com.ypy.interf.IMessage;

/**
 * 
 */
public class Dao {
	//��ѯ
	public List<Message> selectMessage(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		Message message = new Message();
		message.setCommand(name);
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			//�ȵ��ýӿ��еķ���
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.selectMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	//��ҳ��ѯ
		public List<Message> selectMessageByPage(Map<String,Object> parameter) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			List<Message> messageList = new ArrayList<Message>();
			try {
				sqlSession = dbAccess.getSqlSession();
				//ͨ��sqlSessionִ��SQL���
				//�ȵ��ýӿ��еķ���
				IMessage imessage = sqlSession.getMapper(IMessage.class);
				messageList = imessage.selectMessageByPage(parameter);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}
			return messageList;
		}
	
	//����ɾ��
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.selectList("Message.deleteOne",id);//ֻ����һ�����������Ҫ������������Ͷ�����з�װ
			sqlSession.commit();//�Զ��ύ
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//����ɾ��
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.selectList("Message.deleteBatch",ids);//ֻ����һ�����������Ҫ������������Ͷ�����з�װ
			sqlSession.commit();//�Զ��ύ
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//һ�Զ��ϵ��ѯ
	public List<Command> selectCommand(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command> commandList = new ArrayList<Command>();
		Command command = new Command();
		command.setName(name);
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
			commandList = sqlSession.selectList("Command.selectCommand",command);//ֻ����һ�����������Ҫ������������Ͷ�����з�װ
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
	
	//��������
		public void insertBatch(List<Message> message) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				IMessage imessage = sqlSession.getMapper(IMessage.class);
				imessage.insertBatch(message);
				sqlSession.commit();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}
		}
}
