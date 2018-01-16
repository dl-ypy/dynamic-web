<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中北大学选课管理</title>
	<style>
		#dl{
			height:560px;
			weight:1280px；
		}
		#dl1{
			width:300px;
			margin:0px auto;
		}
	
	</style>
</head>
<body style="background:url(images/2.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<div id=dl>
		<br><br><br><br><br><br><h1 align="center"><b>大学生教务管理入口</b></h1>
		<div  id="dl1">
			<form id="formqt" method="post" action="Servletst" target="_blank">
				<table>
					<tr>
					<td>学&nbsp;&nbsp;&nbsp;&nbsp;号:</td><td><input type="text" name="st_id" value=""></td>
					</tr>
					<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td><td><input type="password" name="st_password" value=""></td>
					</tr>
					
					<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登陆"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>