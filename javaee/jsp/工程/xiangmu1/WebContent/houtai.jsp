<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>后台管理</title>
	
	       <!-- frameset标签不能与body一起使用 -->
		
		<frameset cols="180,*">
			<frame src="zuo.jsp" name="zuo" noresize>
			<frame src="you.jsp" name="you" noresize>
		</frameset>
	
</head>
<body>
	<%
		if(session.getAttribute("username") == null)//查看"通行证"  如果为空，返回首页
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
</body>
		

</html>