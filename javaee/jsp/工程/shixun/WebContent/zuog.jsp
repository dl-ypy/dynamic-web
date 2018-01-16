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
	<center><h3>选择界面</h3></center>
	<center>
	<a href="Select_stg.jsp" target="you">学生管理</a><br>
	<a href="Select_kc.jsp" target="you">课程管理</a><br>
	<a href="Select_th.jsp" target="you">教师管理</a><br>
	<a href="Select_cj.jsp" target="you">成绩查询</a><br>
	<a href="Select.jsp" target="you">选课情况</a></center>
	</div>
</body>
</html>