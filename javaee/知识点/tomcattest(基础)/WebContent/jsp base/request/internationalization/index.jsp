<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>页面信息国际化</title>
</head>
<body>
	<%
		java.util.Locale locale = request.getLocale();
		String str = "";
		if (locale.equals(java.util.Locale.US))
		{
			str = "Hello, welcome to access our company's web!";
			//如果所在区域是外国，则显示这个
		}
		if (locale.equals(java.util.Locale.CHINA))
		{
			str = "您好，欢迎访问我们公司的网站！";
			//如果所在区域为中国，则显示这个
		}
	%>
	<%=str%>
</body>
</html>