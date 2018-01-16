<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
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
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "12345678900");
		
		String sqlQuery = "select count(*) from user where username = ?";
		PreparedStatement psQuery = conn.prepareStatement(sqlQuery);
		psQuery.setString(1, username);
		ResultSet rs = psQuery.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		if (count > 0) {
			response.sendRedirect("registerFail.jsp");
			psQuery.close();
			conn.close();
			return;
		}
		
		String sql = "insert into user values (null,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
		ps.close();
		conn.close();
		response.sendRedirect("registerSuccess.jsp");
	%>
</body>
</html>