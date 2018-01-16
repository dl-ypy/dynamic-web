<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.chengji.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.shixun.student.*" %>
<%@ page import="com.shixun.kecheng.*" %>
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
		Daok daok = new Daok();
		Yhs yhs = new Yhs();
		Yhc yhc = new Yhc();
		yhs.setKc_id(request.getParameter("kc_id"));
		yhs.setTh_id(request.getParameter("th_id"));
		yhs.setSt_id(request.getParameter("st_id"));
		yhc.setKc_id(request.getParameter("kc_id"));
		
		int rs = daok.Xuanke(yhs, yhc);
		if (rs != 0)
		{%>
			<jsp:forward page="Tiaozhuan.jsp"/>
		<%}
		else
		{
			out.println("失败");
		}
	%>
</body>
</html>