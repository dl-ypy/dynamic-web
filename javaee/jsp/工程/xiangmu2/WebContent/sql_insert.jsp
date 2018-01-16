<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %><!-- 需要引入包 -->
<%@ page import="com.xiangmu2.yh.Yhgl" %>
<%@ page import="com.xiangmu2.dao.*" %>
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

	<%
		request.setCharacterEncoding("utf-8");
	
		Yhgl yh = new Yhgl();
		UserDao user = new UserDao();
		//先通过yh得到表单传过来的值
		yh.setUsername(request.getParameter("username"));
		yh.setPassword(request.getParameter("password"));
		yh.setType(request.getParameter("type"));
		yh.setPhone(request.getParameter("phone"));
		yh.setAddress(request.getParameter("address"));
		yh.setYouxiang(request.getParameter("youxiang"));
		yh.setSex(request.getParameter("sex"));
		
		int rs = user.Insert(yh);//调用添加的方法
		
		if (rs != 0)//判断是否添加成功
		{%>
			<jsp:forward page="houtai.jsp"/>	
		<%}
		else
		{
			out.println("添加失败！");
		}
		
	%>						
	
</body>
</html>