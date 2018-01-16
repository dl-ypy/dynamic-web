<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.chengji.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		Daoc daoc = new Daoc();
		int pages = 0;
		int currpage = 1;
		int count = daoc.Selectcount();
		
		if (count%Yhc.page_size == 0)
		{
			pages = count/Yhc.page_size;
		}
		else
		{
			pages = count/Yhc.page_size+1;
		}
		
		if (request.getParameter("pages") != null)
		{
			currpage = Integer.parseInt(request.getParameter("pages"));
		}
		
		for (int i=1; i<=pages; i++)
		{
			if (i == currpage)
			{
				out.println(i);
			}
			else
			{
				out.println("<a href='Select_cj.jsp?pages="+i+"'>"+i+"</a>");
			}
		}
	%>

</body>
</html>