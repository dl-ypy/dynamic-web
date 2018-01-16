<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		request.setCharacterEncoding("utf-8");
	
		Yh yh = new Yh();
		Dao dao = new Dao();
		//先通过yh得到表单传过来的值
		yh.setTh_name(request.getParameter("th_name"));
		yh.setTh_password(request.getParameter("th_password"));
		yh.setTh_type(request.getParameter("th_type"));
		yh.setTh_zhiwei(request.getParameter("th_zhiwei"));
		yh.setTh_sex(request.getParameter("th_sex"));
		
		int rs = dao.insert(yh);
		
		if (rs != 0)
		{%>
			<jsp:forward page="Select_th.jsp"/>	
		<%}
		else
		{
			out.println("添加失败！");
		}
		
	%>
</body>
</html>