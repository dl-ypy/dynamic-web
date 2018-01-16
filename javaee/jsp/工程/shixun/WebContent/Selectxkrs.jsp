<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.student.*" %>
<%@ page import="com.shixun.kecheng.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		Daok daok = new Daok();
		Yhs yhs = new Yhs();
		yhs.setKc_id(request.getParameter("kc_id"));
		ResultSet rs = daok.Selectrs(yhs);
		if (rs.next())
		{
	%>
	<h1><b><i>本课程学生人数为<%=rs.getString("count(*)")%>人。</i></b></h1>
	<%} %>
</body>
</html>