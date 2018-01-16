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
<tr><td><%=kc.getKc_id() %></td><td><%=kc.getKc_name() %></td><td><%=kc.getTh_id()%></td><td><%=kc.getKc_address()%></td><td><a href="Updatekc.jsp?kc_id=<%=kc.getKc_id()%>">修改</a>&nbsp;&nbsp;&nbsp;<a href="Deletekc.jsp?kc_id=<%=kc.getKc_id()%>">删除</a></td></tr>
<%
  }
%>
</table>
<jsp:include page="fy_kc.jsp"/><br>
<a href="Insertkc.jsp">添加题目</a>
</body>
</html>
