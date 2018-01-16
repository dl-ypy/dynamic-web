<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String a = request.getParameter("yh0");//接收名字
		
		if(a.equals("c"))//判断a的值是否和"c"相等
		{%>
			<jsp:forward page="Success.jsp"/><!-- 跳转指令  单独的指令  所以上下都需要分开括 -->
		<%}
		else
		{%>
			<jsp:forward page="Fail.jsp"/>
		<%}
	%>
</body>
</html>