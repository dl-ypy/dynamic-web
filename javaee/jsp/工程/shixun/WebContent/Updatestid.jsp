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
   Yhc yhc = new Yhc();
   yhc.setSt_id(request.getParameter("st_id"));
   Daos selectid=new Daos();
   ResultSet rs=selectid.selectid(yhc);
   if(rs.next()){
%>
  <form action="DoUpdatestid.jsp?st_id=<%=rs.getString("st_id") %>" method="post">
  <table>
     <tr><td>分数:</td><td><input type="text" name="cj" value="<%=rs.getString("cj")%>"></td></tr>
 <tr><td><input type="submit" value="修改"></td>
 <td><input type="reset" value="取消"></td></tr>
 </table>
 </form>
<%
   }
%>
</body>
</html>
