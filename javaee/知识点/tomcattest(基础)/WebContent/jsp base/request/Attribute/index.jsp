<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		try
		{
			int money = 100;
			int number = 0;
			request.setAttribute("result", money/number);  //保存执行结果
		}
		catch(Exception e)
		{
			request.setAttribute("result", "页面发生错误！");  //保存如果发生错误而产生的提示信息
		}
	%>
	<jsp:forward page="deal.jsp"/>
</body>
</html>