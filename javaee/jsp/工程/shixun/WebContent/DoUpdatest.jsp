<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.student.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>DoUpdate.jsp page</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<%
   request.setCharacterEncoding("UTF-8");
   Yhs stu=new Yhs();
   stu.setSt_id(request.getParameter("st_id"));
   stu.setSt_banji(request.getParameter("st_banji"));
   stu.setSt_xi(request.getParameter("st_xi"));
   Daos update=new Daos();
   int rs=update.Update(stu);
   if (rs != 0)
	{%>
		<jsp:forward page="Select_stg.jsp"/>	
	<%}
	else
	{
		out.println("修改失败！");
	}
%>
</body>
</html>
