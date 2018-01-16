<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="com.shixun.kecheng.*" %>
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
  Yhk kc=new Yhk();
  kc.setTh_id(request.getParameter("th_id"));
  kc.setKc_name(request.getParameter("kc_name"));
  kc.setKc_address(request.getParameter("kc_address"));
  Daok daok = new Daok();
  int rs = daok.InsertKc(kc);
  if (rs != 0)
	{%>
		<jsp:forward page="Select_kc.jsp"/>	
	<%}
	else
	{
		out.println("添加失败！");
	}
  }
  catch(Exception e){
     out.println(e);
  }
  %>
</body>
</html>