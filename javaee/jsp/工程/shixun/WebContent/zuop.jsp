<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
		#zuo{
			width:160px;
			height:650px;
			background:#FFDDAA;
		}
	</style>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<div id="zuo">
	<center><h3>选择界面</h3>
	<a href="Select_stp.jsp" target="you">我的学生</a><br>
	<a href="Select_kc_thp.jsp" target="you">我的课程</a><br>
	<a href="Select_thp.jsp" target="you">我的信息</a><br>
	<a href="Select_cjp.jsp" target="you">成绩管理</a><br>
	<a href="Select.jsp" target="you">选课信息</a></center>
	</div>
</body>
</html>