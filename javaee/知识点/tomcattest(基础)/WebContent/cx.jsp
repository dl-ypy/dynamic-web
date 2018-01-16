<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %><!-- 需要引入包 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
		String username = null;
		String password = null;
		String type = null;
	%>
	
							<!-- 主体程序 -->
	<%
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER,DBPASS);//相当于铺管子
			request.setCharacterEncoding("utf-8");
			username = request.getParameter("name");
			password = request.getParameter("pas");
			type = request.getParameter("leixing");
			
			String sql_insert = "insert into htgl(name,password,type) values('"+username+"','"+password+"','"+type+"')";
			pst = conn.prepareStatement(sql_insert);
			pst.executeUpdate();//执行指令
			
			out.println("添加成功！");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	%>
	
</body>
</html>