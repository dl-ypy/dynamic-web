<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.chengji.*" %>
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
		request.setCharacterEncoding("utf-8");
		Daoc daoc = new Daoc();
		Yhc yhc = new Yhc();
		yhc.setSt_banji(request.getParameter("st_banji"));
		ResultSet rs = daoc.Selectanxs(yhc);
		out.println(request.getParameter("st_banji")+"班的成绩信息如下！");
	%>
	<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
		<tr><th>学生学号</th><th>学生姓名</th><th>课程名称</th><th>教师姓名</th><th>班级</th><th>成绩</th><th>用户操作</th></tr>
		<%
		while (rs.next())
		{
		%>
		<tr><td><%=rs.getString("S.st_id")%></td><td><%=rs.getString("S.st_name")%></td><td><%=rs.getString("K.kc_name")%></td><td><%=rs.getString("T.th_name")%></td><td><%=rs.getString("S.st_banji")%></td><td><%=rs.getString("C.cj")%></td><td><a href="Selectanbjzt.jsp?st_banji=<%=rs.getString("S.st_banji")%>">查看该班级整体情况</a></td></tr>
		<%}%>
	</table>
</body>
</html>