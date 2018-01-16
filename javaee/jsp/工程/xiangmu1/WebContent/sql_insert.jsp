<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %><!-- 需要引入包 -->
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

							<!-- 定义常量 -->
	<%!
		public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
		public static final String DBURL = "jdbc:mysql://localhost:3307/ZBDX";
		public static final String DBUSER = "root";
		public static final String DBPASS = "12345678900";
	%>
	
							<!-- 定义变量 -->
	<%
		Connection conn = null;//相当于管子
		PreparedStatement pst = null;//相当于执行指令的人
		
		//要接收的数据
		
		int rs = 0;
	%>
	
							<!-- 主体程序 -->
	<%
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER,DBPASS);//相当于铺管子
			request.setCharacterEncoding("utf-8");
			Yhgl yh = new Yhgl();   //创建一个对象
			yh.setUsername(request.getParameter("username"));//调用set方法给属性赋值
			yh.setPassword(request.getParameter("password"));
			yh.setType(request.getParameter("type"));
			
			String sql_insert = "insert into htgl(username,password,type) values('"+yh.getUsername()+"','"+yh.getPassword()+"','"+yh.getType()+"')";
			pst = conn.prepareStatement(sql_insert);
			rs = pst.executeUpdate();//执行指令
			
			if (rs != 0)
			{%>
				<jsp:forward page="houtai.jsp"/>
			<%}
			else
			{
				out.println("添加失败！");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
	
</body>
</html>