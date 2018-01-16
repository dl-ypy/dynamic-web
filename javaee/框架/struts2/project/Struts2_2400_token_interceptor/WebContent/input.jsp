<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	拦截重复提交（不常用）
	<form action="user" method="post">
		<input type="text" name="name"/>
		<input type="text" name="age"/>
		<input type="submit" value="add"/>
		<s:token></s:token>
	</form>
</body>
</html>