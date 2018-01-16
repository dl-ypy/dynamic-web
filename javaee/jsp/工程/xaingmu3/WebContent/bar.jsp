<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xiangmu2.dao.*" %>
<%@ page import="com.xiangmu2.yh.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDao user = new UserDao();
		Yhgl yh = new Yhgl();
		int page1 = 0;    //这里不能再定义为page(????)
		int currpage = 1;//当前页为第几页
		int counts = user.Selectcount();//查询共几条记录
		//StringBuffer fy = new StringBuffer();//追加页数时用的类      ????????为什么不能用
		
		//判断有几页  如果总记录数对每页的记录数取余为0，就有counts/page_size页，否则+1
		if (counts%Yhgl.page_size == 0)
		{
			page1 = counts/Yhgl.page_size;
		}
		else
		{
			page1 = counts/Yhgl.page_size+1;
		}
	    
		
		//判断是否为当前页
				if (request.getParameter("page1") != null)//如果得到的页数不为空（因为会超链接到这里），就将当前页变为得到的页数
				{
					currpage = Integer.parseInt(request.getParameter("page1"));//request得到的是String类型的，要转换为int型
				}
				
				for (int i=1; i<=page1; i++)
				{
					if (i == currpage)//如果是当前页直接追加，不加超链接
					{
						out.println(i);  //追加i的值
					}
					else
					{
						out.println("<a href='List.jsp?page1="+i+"'>"+i+"</a>");//不是当前页的要加超链接
					}
					out.println(" ");
				}
		
		
		
	%>
</body>
</html>