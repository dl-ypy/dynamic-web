<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
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
	
	<%!
		public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
		public static final String DBURL = "jdbc:mysql://localhost:3307/ZBDX";
		public static final String DBUSER = "root";
		public static final String DBPASS = "12345678900";
	%>
	
	<%
		Connection conn = null;
		PreparedStatement pst = null;
		String id = null;
		ResultSet rs = null;
	%>
	
	<%
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			request.setCharacterEncoding("utf-8");
			id = request.getParameter("id");//结收通过?传的id值
			String sql_select = "select * from htgl where id = '"+id+"'";//先显示，再修改
			pst = conn.prepareStatement(sql_select);
			rs = pst.executeQuery();
			if (rs.next())
			{
		%>
		<form action="sql_update2.jsp?id=<%=rs.getString("id")%>" method="post">
			用户名：<input type="text" name="username" value="<%=rs.getString("username")%>">
			密码：<input type="text" name="password" value="<%=rs.getString("password")%>">
			用户身份：<select name="type">
						<option value="管理员">管理员</option>
						<option value="普通用户">普通用户</option>
					</select><br>
			<input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消">
		</form>
		<%
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
</body>
</html>