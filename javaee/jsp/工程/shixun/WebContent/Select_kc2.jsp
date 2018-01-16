<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="com.shixun.kecheng.*" %>
<%@ page import="com.shixun.student.*" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>查询课程</title>
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
int currpage = 1;
if (request.getParameter("pages") != null)
{
	currpage = Integer.parseInt(request.getParameter("pages"));
}
  Daok daok = new Daok();
  List<Yhk> list=new ArrayList<Yhk>();
  list=daok.SelectKc(currpage);
  Iterator<Yhk> iter=list.iterator();
%>
<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
<tr><th>选修课编号</th><th>选修课名称</th><th>教师编号</th><th>选修课教室</th><th>用户操作</th></tr>
<%
  while (iter.hasNext()){
  Yhk kc=iter.next();
%>
<tr><td><%=kc.getKc_id() %></td><td><%=kc.getKc_name() %></td><td><%=kc.getTh_id()%></td><td><%=kc.getKc_address()%></td><td><a href="Xuanke.jsp?th_id=<%=kc.getTh_id()%>&kc_id=<%=kc.getKc_id()%>&st_id=<%=session.getAttribute("userid").toString()%>">选课</a></td></tr>
<%
  }
%>
</table>
<jsp:include page="fy_kc.jsp"/><br>
</body>
</html>
