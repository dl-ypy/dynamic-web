<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="com.shixun.teacher.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成功</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<% 
  try{
  request.setCharacterEncoding("UTF-8");
  Yh yht = new Yh();
  yht.setTh_id(request.getParameter("th_id"));
  yht.setTh_name(request.getParameter("th_name"));
  yht.setTh_password(request.getParameter("th_password"));
  yht.setTh_phone(request.getParameter("th_phone"));
  yht.setTh_sex(request.getParameter("th_sex"));
  Dao daot = new Dao();
  int rs = daot.update(yht);
  if (rs != 0)
	{%>
		<jsp:forward page="Select_thp.jsp"/>	
	<%}
	else
	{
		out.println("修改失败！");
	}
  }
  catch(Exception e){
     out.println(e);
  }
  %>
</body>
</html>