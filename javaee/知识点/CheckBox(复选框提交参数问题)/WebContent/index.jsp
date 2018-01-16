<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>复选框提交参数问题</title>
</head>
<body>
	<form action="Servlet" method="get">
		<input type="checkbox" name="hobbies" value="Basketball"/>Basketball<br>
		<input type="checkbox" name="hobbies" value="Football"/>Football<br>
		<input type="checkbox" name="hobbies" value="Coding"/>Coding<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>