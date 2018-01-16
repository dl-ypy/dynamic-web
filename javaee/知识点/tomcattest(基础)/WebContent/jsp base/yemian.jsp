<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>  <%--引入包 --%>
<%@ page import="java.text.SimpleDateFormat" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>显示系统时间</title>
</head>
<body>
		<%--简单，但需要不停的刷新 --%>
		
	<%
		Date date = new Date();//获取时间对象
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置格式
		String today = df.format(date);//获取当前系统时间
		response.setHeader("refresh", "1");//每秒刷新一次
	%>
	当前时间：<%=today%>
</body>
</html>