//������ת��Ϊ�ַ���
package com.xiangmu2.atos;

public class Atos{
	public String atos(String[] arr)
	{
		StringBuffer sb = new StringBuffer();//��������
		if (arr!=null && arr.length>0)//�ж��Ƿ�Ϊ��Ч����
		{
			for (String s:arr)//��������
			{
				sb.append(s);//���ַ���׷�ӵ�StringBuffer��
				sb.append(",");//���ַ���׷�ӵ�StringBuffer��
			}
			if (sb.length() > 0)//�ж��ַ��������Ƿ���Ч
			{
				sb = sb.deleteCharAt(sb.length()-1);//��ȡ�ַ�
			}
		}
		
		return sb.toString();//�����ַ���
	}
}
