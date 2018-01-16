<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if((session.getAttribute("username")) == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<center><h3>选择界面</h3></center>
	<a href="you1.jsp" target="you">用户管理</a><br>
	<a href="you2.jsp" target="you">新闻管理</a>
</body>
</html>