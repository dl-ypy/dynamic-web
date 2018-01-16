<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="duixiang" class="useBean.User"></jsp:useBean><%--id是对象名，class是包.类名 --%>
	<jsp:setProperty name="duixiang" property="name" value="ypy"/><%--给属性赋值，name是初始化的对象名，property是要赋值的属性，value是要给属性赋的值 --%>
	<jsp:getProperty name="duixiang" property="name"/><%--得到属性的值 --%>
	<jsp:setProperty name="duixiang" property="age" value="22"/><%--必须有"", scope为有效范围--%>
	<jsp:getProperty name="duixiang" property="age"/>
	
	<jsp:setProperty name="duixiang" property="*"/><%--有*的只有是前面有一个页面传过来值的情况才能用，相当于把前面页面传过来的值通过request.getParameter挨着放进去 --%>
</body>
</html>