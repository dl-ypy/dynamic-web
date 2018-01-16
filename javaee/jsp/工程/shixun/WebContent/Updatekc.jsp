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
<title>Update.jsp page</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<%
   Yhk kc=new Yhk();
   kc.setKc_id(request.getParameter("kc_id"));
   Daok daok=new Daok();
   ResultSet rs=daok.SelectKcId(kc);
   if(rs.next()){
%>
  <form action="DoUpdatekc.jsp?kc_id=<%=rs.getString("kc_id") %>" method="post">
  <table>
     <tr><td>选修课名称:</td><td><input type="text" name="kc_name" value="<%=rs.getString("kc_name")%>"></td></tr>
     <tr><td>教师编号:</td><td><input type="text" name="th_id" value="<%=rs.getString("th_id")%>"></td></tr>
     <tr><td>选修课地址:</td><td><input type="text" name="kc_address" value="<%=rs.getString("kc_address")%>"></td></tr>
     <tr><td><input type="submit" value="提交"></td>
     <td><input type="reset" value="取消"></td></tr>
     </table>
  </form>
<%
   }
%>
</body>
</html>

