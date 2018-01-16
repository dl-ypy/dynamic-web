<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>重定向网页</title>
</head>
<body>
	<%
		response.sendRedirect("https://www.baidu.com");
		//重定向到和此页面不在同一主机下的页面
		//重定向后，将开始一个新的request对象
	%>
</body>
</html>