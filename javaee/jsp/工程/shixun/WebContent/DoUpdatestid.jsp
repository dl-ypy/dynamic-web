<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.chengji.*" %>
<%@ page import="com.shixun.student.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
   Yhc yhc=new Yhc();
   yhc.setSt_id(request.getParameter("st_id"));
   yhc.setCj(request.getParameter("cj"));
   Daos update=new Daos();
   int rs=update.updatept(yhc);
   if (rs != 0)
   {%>
	   <jsp:forward page="Select_stp.jsp"/>
   <%}
   else
   {
	   out.println("录入/修改失败！");
   }
   
%>
</body>
</html>