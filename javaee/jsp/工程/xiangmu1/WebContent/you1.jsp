<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu1.yh.Yhgl" %>
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
	<%!
		public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	    public static final String DBURL = "jdbc:mysql://localhost:3307/ZBDX";
	    public static final String DBUSER = "root";
	    public static final String DBPASS = "12345678900";
	%>
	
	<%
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;//保存结果的集合
	%>
	
	<%
		try
		{
			Yhgl yh = new Yhgl();
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			request.setCharacterEncoding("utf-8");
			yh.setUsername(request.getParameter("username"));
			yh.setPassword(request.getParameter("password"));
			yh.setType(request.getParameter("type"));
			
			String sql_select = ("select * from htgl");
			pst = conn.prepareStatement(sql_select);
			rs = pst.executeQuery();
			%>
			<table border=1>
				<tr><th>编号</th><th>用户名</th><th>密码</th><th>用户类型</th><th>数据操作</th></tr>
				<%
				while (rs.next())
				{
				%>
				<tr><td><%=rs.getString("id")%></td><td><%=rs.getString("username")%></td><td><%=rs.getString("password") %></td><td><%=rs.getString("type")%></td><td>&nbsp;&nbsp;<a href="sql_update1.jsp?id=<%=rs.getString("id")%>">修改</a>&nbsp;&nbsp;<a href="sql_delete.jsp?id=<%=rs.getString("id") %>">删除</a></td></tr>
				<%--通过?传id值 --%>
			
			
		<% 
			}%>
				</table>   <!-- 表格必须把while语句包括进去 -->
		<%}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
	<br>
	<a href="sql_insertd.jsp">添加用户</a>
</body>
</html>