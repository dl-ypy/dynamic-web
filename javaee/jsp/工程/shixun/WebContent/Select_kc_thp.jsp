<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.kecheng.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Select.jsp page</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<% 
  request.setCharacterEncoding("UTF-8");
  Daok select=new Daok();
  Yhk yhs = new Yhk();
  yhs.setTh_id(session.getAttribute("userid").toString());
  ResultSet rs = select.SelectKcpt(yhs);
%>
<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
<tr><th>课程编号</th><th>课程名称</th><th>上课地址</th></tr>
<%
  while (rs.next()){
  
%>
<tr><td><%=rs.getString("kc_id")%></td><td><%=rs.getString("kc_name")%></td><td><%=rs.getString("kc_address")%></td></tr>
<%
  }
%>
</table>
</body>
</html>
