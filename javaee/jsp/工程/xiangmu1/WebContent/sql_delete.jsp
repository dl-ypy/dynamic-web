<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu1.yh.Yhgl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		int rs = 0;//因为删除的是一列，而不是一个集合，所以为int类型
	%>
	
	<%
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			request.setCharacterEncoding("utf-8");
			id = request.getParameter("id");
			String sql_delete = "delete from htgl where id='"+id+"'";
			pst = conn.prepareStatement(sql_delete);
			rs = pst.executeUpdate();
			if (rs != 0)
			{%>
				<jsp:forward page="you1.jsp"/>
			<%}
			else
			{
				out.println("删除失败！");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
</body>
</html>