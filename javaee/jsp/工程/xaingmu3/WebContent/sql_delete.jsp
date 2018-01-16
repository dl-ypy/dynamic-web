<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu2.yh.Yhgl" %>
<%@ page import="com.xiangmu2.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>

	<%
		Yhgl yh = new Yhgl();
		UserDao user= new UserDao();
		yh.setId(request.getParameter("id"));
		int rs = user.Delete(yh);
		
		if (rs != 0)
		{%>
			<jsp:forward page="you1.jsp"/>
		<%}
		else
		{
			out.println("删除失败！");
		}
	%>
</body>
</html>