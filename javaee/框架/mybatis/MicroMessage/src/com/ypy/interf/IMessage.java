package com.ypy.interf;

import java.util.List;
import java.util.Map;

import com.ypy.bean.Message;

/**
 * ��Message�����ļ����Ӧ�Ľӿ�
 * ��ֹ����selectList����ʱ����Ĳ������ִ���
 * ��������Ĳ������͵���ӿ��ж���Ĳ�һ�£��ͻ�������Ծ���֪���������ڡ�
 */
public interface IMessage {
	//Ҫ���������ļ��е��ĸ����������ø÷�����id��������
	//����������Ҳ�������ļ������õ�����
	public List<Message> selectMessage(Message message);
	public List<Message> selectMessageByPage(Map<String, Object> parameter);
	public void insertBatch(List<Message> message);
}
