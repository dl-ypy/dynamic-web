<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%!int count = 0; %><!-- 定义全局变量 -->
	<%
		out.println("恭喜您注册成功！");
		int a = 5-count;
		count++;
		response.setHeader("refresh", "1");//1秒钟刷新一次页面
		if(count == 6)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<br>
	<%=a%>秒后将返回首页！
	<%a--;%>
</body>
</html>