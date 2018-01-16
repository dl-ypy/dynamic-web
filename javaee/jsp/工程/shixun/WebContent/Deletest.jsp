<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.student.*" %>
<%@ page import="com.shixun.chengji.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Delete.jsp page</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<%
  Yhs stu=new Yhs();
  Yhc yhc = new Yhc();
  stu.setSt_id(request.getParameter("st_id"));
  yhc.setSt_id(request.getParameter("st_id"));
  Daos delete=new Daos();
  int rs1 = delete.Deletecj(yhc);
  int rs=delete.Delete(stu);
  if (rs!=0 && rs!=0)
  {
  %>
	  <jsp:forward page="Select_stg.jsp"></jsp:forward>
  <%
  }
  else
  {
	  out.println("删除失败！");
  }
  %>
</body>
</html>
