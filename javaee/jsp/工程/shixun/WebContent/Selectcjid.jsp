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
   Yhc yhc = new Yhc();
   yhc.setSt_id(request.getParameter("st_id"));
   yhc.setKc_id(request.getParameter("kc_id"));
   Daoc daoc = new Daoc();
   ResultSet rs=daoc.Selectxs(yhc);
   if(rs.next()){
%>
  <table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
     <tr><th>选修课名称</th><th>教师姓名</th><th>我的成绩</th><th>学年</th><th>学期</th></tr>
     <tr><td><%=rs.getString("K.kc_name")%></td><td><%=rs.getString("T.th_name")%></td><td><%=rs.getString("C.cj")%></td><td><%=rs.getString("C.xuenian")%></td><td><%=rs.getString("C.xueqi")%></td></tr>
  </table>
<%
   }
   else
   {
	   out.println("你还没有选课！");
   }
%>
</body>
</html>

