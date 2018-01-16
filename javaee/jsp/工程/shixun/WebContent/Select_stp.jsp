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
  Daos select=new Daos();
  Yhs yhs = new Yhs();
  yhs.setTh_id(session.getAttribute("userid").toString());
  ResultSet rs = select.Selectpt(yhs);
%>
<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
<tr><th>学生学号</th><th>学生姓名</th><th>学生性别</th><th>学生联系方式</th><th>所在班级</th><th>所在系</th><th>课程名称</th><th>所得分数</th><th>学年</th><th>学期</th><th>用户操作</th></tr>
<%
  while (rs.next()){
  
%>
<tr><td><%=rs.getString("S.st_id")%></td><td><%=rs.getString("S.st_name")%></td><td><%=rs.getString("S.st_sex")%></td><td><%=rs.getString("S.st_phone")%></td><td><%=rs.getString("S.st_banji")%></td><td><%=rs.getString("S.st_xi")%></td><td><%=rs.getString("K.kc_name")%></td><td><%=rs.getString("C.cj")%></td><td><%=rs.getString("C.xuenian")%></td><td><%=rs.getString("C.xueqi")%></td><td><a href="Updatestid.jsp?st_id=<%=rs.getString("S.st_id")%>">录入/修改学生成绩</a></tr>
<%
  }
%>
</table>
</body>
</html>
