<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.kecheng.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.shixun.student.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
	Daok dao = new Daok();
	Yhs yhs = new Yhs();
	yhs.setSt_id(request.getParameter("st_id"));
	
	int rs = dao.Tuike(yhs);
	
	if (rs != 0)
	{%>
		<jsp:forward page="Select_st.jsp"/>
	<%}
	else
	{
		out.println("失败");
	}
	%>
</body>
</html>