<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.ypy.login.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/login.css" rel="stylesheet"/>
<script src="js/login.js" type="text/javascript"></script>
</head>
<body>
	<%
		String username = CookieUtil.getCookie(request, "username");
		String password = CookieUtil.getCookie(request, "password");
	%>
	<div id="login">
			<form action="LoginServlet" method="get">
				<table>
					<tr>
						<td id="firsttrtd"><span>以下均为必须填</span></td>
					</tr>
					<tr>
						<td id="firsttd">用户名：</td>
						<td id="seondtd"><input id="username" type="text" name="username" value="<%=username%>"/><span id="name_span">必须是英文字母或数字，长度3-15</span></td>
					</tr>
					<tr>
						<td id="firsttd">密码：</td>
						<td id="seondtd"><input id="password" type="password" name="password" value="<%=password%>"/><span id="pwd_span">长度3-15</span></td>
					</tr>
					<tr>
						<td colspan="2" id="rembertd"><input name="rember" id="rember" type="checkbox" onclick="ruleRemberSelect()"/><span>记住密码</span></td>
					</tr>
					<tr>
						<td id="submit" colspan="2"><input type="submit" value="提交"/><input type="reset" value="重置"/></td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>