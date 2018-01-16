<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body bgcolor="yellow">
	    使用通配符可以把配置量降到最低<br>
	    不过一定要遵守“约定优于配置”的原则<br>
	  <a href="<%=basePath%>user/user/Teacher_add">添加老师</a>
	  <a href="<%=basePath%>user/user/Teacher_delete">删除老师</a>
	  <a href="<%=basePath%>user/user/Course_add">添加课程</a>
	  <a href="<%=basePath%>user/user/Course_delete">删除课程</a>
  </body>
</html>
