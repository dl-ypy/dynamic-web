<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ypy.dao.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	UserDao userdao = new UserDao();
	ResultSet rs = userdao.selectById(id);
	if (rs.next()) {
	%>
	<form action="UserUpdateServlet?id=<%=rs.getInt("id")%>" method="post">
		用户名：<input type="text" name="username" value="<%=rs.getString("username")%>"/><br/>
		密码：<input type="text" name="password" value="<%=rs.getString("password")%>"/><br>
		电话：<input type="text" name="phone" value="<%=rs.getString("phone")%>"/><br/>
		密保答案：<input type="text" name="answer" value="<%=rs.getString("answer")%>"/><br/>
		邮箱：<input type="text" name="email" value="<%=rs.getString("email")%>"/><br/>
		<input type="submit" value="修改"/>
		<input type="reset" value="重置"/>
	</form>
	<%} %>
</body>
</html>