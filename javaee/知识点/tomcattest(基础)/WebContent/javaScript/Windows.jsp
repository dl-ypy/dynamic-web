<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>window对象，页面的打开和关闭</title>
</head>
<body>
	<form>
		<input type="submit" value="打开" onclick="window.open('Data.jsp','data','width=531,height=402,top=50,left=20')">
		<%--window.open()能够打开一个新的网页，并对其进行设置 --%>
		<input type="submit" value="关闭" onclick="window.close()">
		<%--window.close()能够关闭网页 --%>
	</form>
</body>
</html>