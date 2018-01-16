<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		Daos daos = new Daos();
		Yhs yhs = new Yhs();
		yhs.setSt_id(session.getAttribute("userid").toString());
		ResultSet rs = daos.Selectxs(yhs);
		if (rs.next())
		{%>
			<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
				<tr><th>我的学号</th><th>我的姓名</th><th>我的密码</th><th>我的性别</th><th>我的联系方式</th><th>我的班级</th><th>我所在的系</th><th>我的选修课编号</th><th>我的教师编号</th><th>用户操作</th><th>查询</th></tr>
				<tr><td><%=rs.getString("st_id")%></td><td><%=rs.getString("st_name")%></td><td><%=rs.getString("st_password")%></td><td><%=rs.getString("st_sex")%></td><td><%=rs.getString("st_phone")%></td><td><%=rs.getString("st_banji")%></td><td><%=rs.getString("st_xi")%></td><td><%=rs.getString("kc_id")%></td><td><%=rs.getString("th_id")%></td><td><a href="Updatexs.jsp?st_id=<%=rs.getString("st_id") %>">修改</a>&nbsp;&nbsp;&nbsp;<a href="Select_kc2.jsp?kc_id=<%=rs.getString("kc_id")%>">选课</a>&nbsp;&nbsp;&nbsp;<a href="Tuike.jsp?st_id=<%=rs.getString("st_id")%>">退课</a></td><td><a href="Select_thid.jsp?th_id=<%=rs.getString("th_id")%>">教师信息</a>&nbsp;&nbsp;&nbsp;<a href="Selectcjid.jsp?st_id=<%=rs.getString("st_id")%>&kc_id=<%=rs.getString("kc_id")%>">成绩查询</a></td></tr>
			</table>
		<%}
	%>
</body>
</html>