<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.ypy.registeration.model.*" %>
<%@ page import="com.ypy.registeration.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		UserManager um = new UserManager();
		boolean exist = um.exists(u);
		if (exist) {
			response.sendRedirect("registerFail.jsp");
			return;
		}
		um.add(u);
		response.sendRedirect("registerSuccess.jsp");
	%>
</body>
</html>