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
	<%
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		request.setCharacterEncoding("UTF-8");
		
		Yhgl yh = new Yhgl();
		UserDao user = new UserDao();
		yh.setUsername(request.getParameter("username"));
		yh.setPassword(request.getParameter("password"));
		yh.setSex(request.getParameter("sex"));
		yh.setPhone(request.getParameter("phone"));
		yh.setYouxiang(request.getParameter("youxiang"));
		yh.setAddress(request.getParameter("address"));
		/*
		yh.setLike(request.getParameterValues("like[]"));//数组要用getParameterValues()
		out.println(yh.getLike()[0]);//返回的值为yh.getLike()[0]
		*/
		
		int rs = user.InsertL(yh);
		
		if (rs == 0)
		{
			out.println("注册失败！");
		}
		else
		{
			out.println("注册成功！");
		}
	%>

	
	
</body>
</html>