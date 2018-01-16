<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
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
	yh.setId(request.getParameter("id"));
	yh.setUsername(request.getParameter("username"));
	yh.setPassword(request.getParameter("password"));
	yh.setPhone(request.getParameter("phone"));
	yh.setAddress(request.getParameter("address"));
	yh.setYouxiang(request.getParameter("youxiang"));
	yh.setType(request.getParameter("type"));
	
	int rs = user.Updatep(yh);
		//out.println(rs);
		if (rs != 0)
		{%>
			<jsp:forward page="you1.jsp"/>
		<%
		}
		else
		{
			out.println(yh.getPhone());
			out.println("修改失败！");
		}
	%>
</body>
</html>