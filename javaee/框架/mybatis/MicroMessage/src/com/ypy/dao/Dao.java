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
	//查询
	public List<Message> selectMessage(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		Message message = new Message();
		message.setCommand(name);
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			//先调用接口中的方法
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
	
	//分页查询
		public List<Message> selectMessageByPage(Map<String,Object> parameter) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			List<Message> messageList = new ArrayList<Message>();
			try {
				sqlSession = dbAccess.getSqlSession();
				//通过sqlSession执行SQL语句
				//先调用接口中的方法
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
	
	//单条删除
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.selectList("Message.deleteOne",id);//只能有一个参数，如果要传多个参数，就对其进行封装
			sqlSession.commit();//自动提交
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//批量删除
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.selectList("Message.deleteBatch",ids);//只能有一个参数，如果要传多个参数，就对其进行封装
			sqlSession.commit();//自动提交
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//一对多关系查询
	public List<Command> selectCommand(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command> commandList = new ArrayList<Command>();
		Command command = new Command();
		command.setName(name);
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			commandList = sqlSession.selectList("Command.selectCommand",command);//只能有一个参数，如果要传多个参数，就对其进行封装
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
	
	//批量新增
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
