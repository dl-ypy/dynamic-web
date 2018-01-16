<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.teacher.*" %>
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
  Dao select=new Dao();
  Yh yht = new Yh();
  yht.setTh_id(session.getAttribute("userid").toString());
  ResultSet rs = select.Selectid(yht);
%>
<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
<tr><th>我的编号</th><th>我的姓名</th><th>我的性别</th><th>我的密码</th><th>用户类型</th><th>我的联系方式</th><th>我的职位</th><th>用户操作</th></tr>
<%
  while (rs.next()){
  
%>
<tr><td><%=rs.getString("th_id")%></td><td><%=rs.getString("th_name")%></td><td><%=rs.getString("th_sex")%></td><td><%=rs.getString("th_password")%></td><td><%=rs.getString("th_type")%></td><td><%=rs.getString("th_phone")%></td><td><%=rs.getString("th_zhiwei")%></td><td><a href="Updatethid.jsp?th_id=<%=rs.getString("th_id")%>">修改我的信息</a></tr>
<%
  }
%>
</table>
</body>
</html>
