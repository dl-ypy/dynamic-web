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
		String user = request.getParameter("username");
	    String pas = request.getParameter("password");
	    if((user.equals("ypy"))&&(pas.equals("123")))
	    {
	    	session.setAttribute("username", user);//如果符合，获取“通行证”  下一级页面通过“通行证”才允许访问，保障安全
	    %>
	    	<jsp:forward page="houtai.jsp"/>
	    <%}
	    else
	    {
	    	response.sendRedirect("Shouye.jsp");//登陆错误时返回首页
	    }
	%>

</body>
</html>