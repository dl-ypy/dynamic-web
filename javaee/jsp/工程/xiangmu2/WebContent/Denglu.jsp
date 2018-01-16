<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu2.yh.*" %>
<%@ page import="com.xiangmu2.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
		public static final String DBURL = "jdbc:mysql://localhost:3307/ZBDX";
		public static final String DBUSER = "root";
		public static final String DBPASS = "12345678900";
	%>
	
	<%
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	%>
	
	<%
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String type = request.getParameter("type");
			String sql = "select * from htgl where username='"+username+"' and password='"+password+"' and type='"+type+"'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			rs.last();
			if(rs.getRow() != 0)//返回行数，但上面那句话不能省略
		    {
		    	session.setAttribute("username", username);//如果符合，获取“通行证”  下一级页面通过“通行证”才允许访问，保障安全
		    	if(type.equals("管理员"))//如果是管理员  可查询全部    否则只能查询自己的
		    	{
		    %>
		    		<jsp:forward page="houtai.jsp"/>
		    <%
		    	}
		    	else  //在这里直接通过id查询
		    	{
		    		%>
		    		<table border=1>
			    		<tr><th>用户名</th><th>密码</th><th>用户类型</th><th>性别</th><th>电话</th><th>邮箱</th><th>住址</th><th>爱好</th><th>数据操作</th></tr>
			    		<tr><td><%=rs.getString("username")%></td><td><%=rs.getString("password") %></td><td><%=rs.getString("type")%></td><td><%=rs.getString("sex")%></td><td><%=rs.getString("phone")%></td><td><%=rs.getString("youxiang")%></td><td><%=rs.getString("address")%></td><td><%=rs.getString("like")%></td><td><a href="sql_updatep1.jsp?id=<%=rs.getString("id")%>">修改</a></td></tr>
			    	</table>
		    		<%
		    	}
		    }
		    else
		    {
		    	response.sendRedirect("Shouye.jsp");//登陆错误时返回首页
		    }

		}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
	
	<%
		/*Yhgl yh = new Yhgl();
		UserDao user = new UserDao();
		yh.setUsername(request.getParameter("username"));
		yh.setPassword(request.getParameter("password"));
		yh.setType(request.getParameter("type"));
	    out.println(user.Panduan(yh));*/
	%>


</body>
</html>