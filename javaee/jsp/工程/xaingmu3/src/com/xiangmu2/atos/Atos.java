//将数组转化为字符串
package com.xiangmu2.atos;

public class Atos{
	public String atos(String[] arr)
	{
		StringBuffer sb = new StringBuffer();//创建对象
		if (arr!=null && arr.length>0)//判断是否为有效数组
		{
			for (String s:arr)//遍历数组
			{
				sb.append(s);//将字符串追加到StringBuffer中
				sb.append(",");//将字符串追加到StringBuffer中
			}
			if (sb.length() > 0)//判断字符串长度是否有效
			{
				sb = sb.deleteCharAt(sb.length()-1);//截取字符
			}
		}
		
		return sb.toString();//返回字符串
	}
}
