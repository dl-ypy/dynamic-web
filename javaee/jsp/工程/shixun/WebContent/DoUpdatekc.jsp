<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.kecheng.*" %>
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
   Yhk kc=new Yhk();
   Yhs yhs = new Yhs();
   kc.setKc_id(request.getParameter("kc_id"));
   kc.setKc_name(request.getParameter("kc_name"));
   kc.setKc_address(request.getParameter("kc_address"));
   kc.setTh_id(request.getParameter("th_id"));
   yhs.setTh_id(request.getParameter("th_id"));
   Daok update=new Daok();
   int rs=update.UpdateKcId(kc, yhs);
   if (rs != 0)
   {%>
	   <jsp:forward page="Select_kc.jsp"/>
   <%}
   else
   {
	   out.println("修改失败！");
   }
   
%>
</body>
</html>