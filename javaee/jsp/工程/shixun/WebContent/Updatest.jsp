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
   Yhs stu=new Yhs();
   stu.setSt_id(request.getParameter("st_id"));
   Daos selectid=new Daos();
   ResultSet rs=selectid.SelectId(stu);
   if(rs.next()){
%>
  <form action="DoUpdatest.jsp?st_id=<%=rs.getString("st_id") %>" method="post">
  <table>
     <tr><td>班级:</td><td><input type="text" name="st_banji" value="<%=rs.getString("st_banji")%>"></td></tr>
     <tr><td>所在系:</td><td><input type="text" name="st_xi" value="<%=rs.getString("st_xi")%>"></td></tr>
 <tr><td><input type="submit" value="修改"></td>
 <td><input type="reset" value="取消"></td></tr>
 </table>
 </form>
<%
   }
%>
</body>
</html>
