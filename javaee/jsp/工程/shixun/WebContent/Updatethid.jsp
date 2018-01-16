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
   Yh yht = new Yh();
   yht.setTh_id(request.getParameter("th_id"));
   Dao selectid=new Dao();
   ResultSet rs=selectid.Selectid(yht);
   if(rs.next()){
%>
  <form action="DoUpdatethid.jsp?th_id=<%=rs.getString("th_id") %>" method="post">
  <table>
     <tr><td>姓名:</td><td><input type="text" name="th_name" value="<%=rs.getString("th_name")%>"></td></tr>
     <tr><td>性别:</td><td><input type="radio" name="th_sex" value="男">男
     				   <input type="radio" name="th_sex" value="女">女</td></tr>
     <tr><td>密码:</td><td><input type="text" name="th_password" value="<%=rs.getString("th_password")%>"></td></tr>
     <tr><td>联系方式:</td><td><input type="text" name="th_phone" value="<%=rs.getString("th_phone")%>"></td></tr>
 <tr><td><input type="submit" value="修改"></td>
 <td><input type="reset" value="取消"></td></tr>
 </table>
 </form>
<%
   }
%>
</body>
</html>
