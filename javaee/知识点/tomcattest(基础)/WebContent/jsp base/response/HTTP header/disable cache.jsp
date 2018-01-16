<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>禁用缓存</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		//缓存可以提高网页显示速度，禁用缓存可以提高安全性
	%>
</body>
</html>