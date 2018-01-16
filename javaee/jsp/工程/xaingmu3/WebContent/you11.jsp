<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu2.yh.Yhgl" %>
<%@ page import="java.util.*" %>
<%@ page import="com.xiangmu2.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<center><h3>操作用户</h3></center>
	<%
		request.setCharacterEncoding("utf-8");
		UserDao user = new UserDao();
		Yhgl yh = new Yhgl();
		yh.setId(session.getAttribute("userid").toString());//要通过getAttribute方法得到id值，并且要通过toString转换为String类型
		ResultSet rs = user.Select_id(yh);
		
		if (rs.next())
		{%>
			<table border=1>
			    		<tr><th>用户名</th><th>密码</th><th>用户类型</th><th>性别</th><th>电话</th><th>邮箱</th><th>住址</th><th>数据操作</th></tr>
			    		<tr><td><%=rs.getString("username")%></td><td><%=rs.getString("password") %></td><td><%=rs.getString("type")%></td><td><%=rs.getString("sex") %></td><td><%=rs.getString("phone")%></td><td><%=rs.getString("youxiang")%></td><td><%=rs.getString("address")%></td><td><a href="sql_updatep1.jsp?id=<%=rs.getString("id")%>">修改</a></td></tr>
			    	</table>
		<%}
		
	%>
</body>
</html>