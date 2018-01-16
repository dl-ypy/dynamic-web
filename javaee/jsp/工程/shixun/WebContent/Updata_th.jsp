<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
<%@ page import="java.util.*" %>
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
		request.setCharacterEncoding("utf-8");
		Yh yh = new Yh();
		Dao dao = new Dao();
		yh.setTh_type(request.getParameter("th_type"));
		yh.setTh_id(request.getParameter("th_id"));
		
		int rs = dao.updateg(yh);
			
		if (rs != 0)
		{%>
			<jsp:forward page="Select_th.jsp"/>
		<%
		}
		else
		{
			out.println("修改失败！");
		}
	%>
</body>
</html>