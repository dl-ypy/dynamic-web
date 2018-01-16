<%@ page language="java" errorPage="/err1.jsp" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><!-- 用errorPage属性在出错后跳转到指定页面 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>语法错误跳转页面</title>
</head>
<body>
	<%int i = 2/0; %>
</body>
</html>