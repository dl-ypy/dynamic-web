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
		String a = request.getParameter("yh0");%>
		
		<jsp:forward page="Successf.jsp">
		<jsp:param name="yh1" value="<%=a%>"/> 
		</jsp:forward>
		<!-- 此处此指令必须是成对的 -->
		<!-- 此处的name必须取个不同的名字  value值用表达式标示写 -->
</body>
</html>