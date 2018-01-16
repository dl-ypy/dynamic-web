<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="admin/Category-update" method="post">
		<input type="hidden" name="category.id" value="<s:property value="category.id"/>"/>
		<s:property value="getText('login.username')"/><input type="text" name="category.name" value="<s:property value="category.name"/>"/>
		<s:property value="getText('login.password')"/><input type="text" name="category.description" value="<s:property value="category.description"/>"/>
		<input type="submit" value="<s:property value="getText('login.update')"/>"/>
	</form>
</body>
</html>