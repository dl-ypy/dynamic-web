<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ypy.dao.*" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		ResultSet rs = userdao.selectByUsernameAndPassword(username, password); 
		if (rs.next()) {
			%>
			<h1>姓名：</h1><%=rs.getString("username") %><br/>
			<h1>密码：</h1><%=rs.getString("password") %><br/>
			<h1>爱好：</h1><%=rs.getString("hobby") %><br/>
			<a href="JumpUserUpdateServlet?id=<%=rs.getString("id")%>">修改信息</a>
			<%
		}
	%>
</body>
</html>