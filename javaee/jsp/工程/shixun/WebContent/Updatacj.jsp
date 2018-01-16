<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
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
   Yhc yhc=new Yhc();
   yhc.setKc_id(request.getParameter("kc_id"));
   yhc.setSt_id(request.getParameter("st_id"));
   Daoc daoc = new Daoc();
   ResultSet rs=daoc.Selectcjid(yhc);
   if(rs.next()){
%>
  <form action="DoUpdatacj.jsp?kc_id=<%=rs.getString("kc_id") %>&st_id=<%=rs.getString("st_id")%>"  method="post">
  <table>
     <tr><td>学生成绩:</td><td><input type="text" name="cj" value="<%=rs.getString("cj")%>"></td></tr>
     <tr><td><input type="submit" value="提交"></td>
     <td><input type="reset" value="取消"></td></tr>
     </table>
  </form>
<%
   }
%>
</body>
</html>

