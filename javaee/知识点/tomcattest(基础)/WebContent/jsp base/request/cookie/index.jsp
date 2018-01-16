<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.URLDecoder" %>   <%--引入包 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();   //获取cookie对象的集合
		String user = "";						   //用户名称
		String date = "";						   //注册时间
		
		if (cookies != null)
		{
			for (int i=0; i<cookies.length; i++)   //变量cookie对象集合
			{
				if (cookies[i].getName().equals("mrCookie"))//如果cookie对象的名字为"mrCookie"
				{
					user = URLDecoder.decode(cookies[i].getValue().split("#")[0]);//获取用户名
					date = cookies[i].getValue().split("#")[1];//获取注册时间
				}
			}
		}
		if ("".equals(user) && "".equals(date))//如果没有注册
		{%>
			游客您好，欢迎初次光临！
			<form action="deal.jsp" method="post">
				请输入姓名：<input type="text" name="user" value=""/>
				<input type="button" value="确定"/>
			</form>
		<%}
		else									//已经注册
		{%>
			欢迎[<b><%=user%></b>]再次光临<br>
			您注册的时间是：<%=date%>
		<%}
	%>
</body>
</html>