<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>刷新页面</title>
</head>
<body>
	<%
		response.setHeader("refresh", "5;URL=../redirect/index.jsp");
		//表示刷新5秒跳到上一级文件夹下的redirect文件下的index.jsp文件
	%>
</body>
</html>