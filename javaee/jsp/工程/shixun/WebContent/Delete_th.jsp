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
		Yh yh = new Yh();
		yh.setTh_id(request.getParameter("th_id"));
		int rs = dao.Delete(yh);
		if (rs != 0)
		{%>
			<jsp:forward page="Select_th.jsp"/>
		<%}
		else
		{
			out.println("删除失败！");
		}
	%>
</body>
</html>