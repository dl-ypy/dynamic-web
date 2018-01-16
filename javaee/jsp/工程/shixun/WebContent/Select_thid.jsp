<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
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
		Dao dao  = new Dao();
		Yh yh = new Yh();
		yh.setTh_id(request.getParameter("th_id"));
		ResultSet rs = dao.Selectid(yh);
		
		if (rs.next())
		{
		
	%>
		<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
			<tr><th>教师编号</th><th>教师姓名</th><th>教师性别</th><th>教师职位</th><th>联系方式</th></tr>
			<tr><td><%=rs.getString("th_id")%></td><td><%=rs.getString("th_name")%></td><td><%=rs.getString("th_sex")%></td><td><%=rs.getString("th_zhiwei")%></td><td><%=rs.getString("th_phone")%></td></tr>
		</table>
	<%
		}
		else
		{
			out.println("你还没有选课！");
		}
	%>
	
</body>
</html>