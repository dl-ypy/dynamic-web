<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
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
		Dao dao = new Dao();
		int pages = 0;
		int currpage = 1;
		int count = dao.Selectcount();
		
		if (count%Yh.page_size == 0)
		{
			pages = count/Yh.page_size;
		}
		else
		{
			pages = count/Yh.page_size+1;
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
				out.println("<a href='Select_th.jsp?pages="+i+"'>"+i+"</a>");
			}
		}
	%>

</body>
</html>