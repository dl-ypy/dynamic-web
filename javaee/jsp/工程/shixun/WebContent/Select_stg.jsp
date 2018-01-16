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
	int currpage = 1;
	if (request.getParameter("pages") != null)
	{
		currpage = Integer.parseInt(request.getParameter("pages"));
	}
  Daos select=new Daos();
  List<Yhs> list=new ArrayList<Yhs>();
  list=select.Select(currpage);
  Iterator<Yhs> iter=list.iterator();
%>
<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
<tr><th>学生学号</th><th>学生姓名</th><th>学生性别</th><th>学生联系方式</th><th>学生所在班级</th><th>学生所在系</th><th>选修课编号</th><th>教师编号</th><th>用户操作</th></tr>
<%
  while (iter.hasNext()){
  Yhs stu=iter.next();
%>
<tr><td><%=stu.getSt_id() %></td><td><%=stu.getSt_name() %></td><td><%=stu.getSt_sex()%></td><td><%=stu.getSt_phone()%></td><td><%=stu.getSt_banji()%></td><td><%=stu.getSt_xi()%></td><td><%=stu.getKc_id()%></td><td><%=stu.getTh_id()%></td><td><a href="Updatest.jsp?st_id=<%=stu.getSt_id()%>">修改</a>&nbsp;&nbsp;&nbsp;<a href="Deletest.jsp?st_id=<%=stu.getSt_id()%>">删除</a></td></tr>
<%
  }
%>
</table>
<a href="Insertst.jsp">添加学生</a><br>
<jsp:include page="fy_st.jsp"/><br>
</body>
</html>
