<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
	
	       <!-- frameset标签不能与body一起使用 -->
		
		<frameset cols="180,*">
			<frame src="zuo0.jsp" name="zuo" noresize>
			<frame src="you.jsp" name="you" noresize>
		</frameset>
	
</head>
<body>
	<%
		if (session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	
	
</body>
</html>