<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%!int count = 0;%>
	<%
		int a = 5 - count;
		int b = 5 - count;
		if (a < 0)
		{
			a = Math.abs(a);//绝对值
			b = Math.abs(b);
			if (a%6 == 1)
			{
				a = 5;
				
			}
			else if(a%6 == 2)
			{
				a = 4;
			}
			else if(a%6 == 3)
			{
				a = 3;
			}
			else if(a%6 == 4)
			{
				a = 2;
			}
			else
			{
				a = 1;
			}
		}
		
		count++;
		out.println("选课成功！");
		out.println(a+"秒后跳转......");
		if (a == 0 || b%6==0)
		{
			response.sendRedirect("Select_st.jsp");
		}
		response.setHeader("refresh", "1");
		
	%>
</body>
</html>