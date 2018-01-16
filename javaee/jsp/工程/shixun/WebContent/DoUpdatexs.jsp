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
   stu.setSt_name(request.getParameter("st_name"));
   stu.setSt_sex(request.getParameter("st_sex"));
   stu.setSt_password(request.getParameter("st_password"));
   stu.setSt_phone(request.getParameter("st_phone"));
   Daos update=new Daos();
   int rs=update.Updatexs(stu);
   if (rs != 0)
	{%>
		<jsp:forward page="Select_st.jsp"/>	
	<%}
	else
	{
		out.println("修改失败！");
	}
%>
</body>
</html>
