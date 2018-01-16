<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.kecheng.*" %>
<%@ page import="com.shixun.student.*" %>
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
		ResultSet rs = daok.Selectcx();
		
		
	%>
	<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
		<tr><th>课程名称</th><th>教师名称</th><th>选课人数</th></tr>
	<%
		while (rs.next())
		{%>
			<tr><td><%=rs.getString("kc_name")%></td><td><%=rs.getString("th_name") %></td><td><a href="Selectxkrs.jsp?kc_id=<%=rs.getString("kc_id")%>">查询选课人数</a></td></tr>
			<%
			}
	
	%>
	</table>
</body>
</html>