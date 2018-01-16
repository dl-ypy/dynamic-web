<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.ypy.cookie.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cookie的写入和读取</title>
</head>
<body>
	<%
		String username = CookieUtil.getCookie(request, "username");
	%>
	<form action="CookiesServlet" method="get">
		<input type="text" name="username" value="<%=username%>"/><br/>
		<input type="submit" value="提交"/>
		
	</form>
</body>
</html>