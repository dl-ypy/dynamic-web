<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.chengji.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		int currpage = 1;
		if (request.getParameter("pages") != null)
		{
			currpage = Integer.parseInt(request.getParameter("pages"));
		}
		Daoc daoc = new Daoc();
		ResultSet rs = daoc.Select(currpage);
	%>
	<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
		<tr><th>编号</th><th>学生姓名</th><th>课程名称</th><th>教师名称</th><th>班级</th><th>分数</th><th>学年</th><th>学期</th><th>用户操作</th><th>其他查询</th></tr>
	<%
		while (rs.next())
		{
		%>
			<tr><td><%=rs.getString("C.cj_id")%></td><td><%=rs.getString("S.st_name")%></td><td><%=rs.getString("K.kc_name")%></td><td><%=rs.getString("T.th_name")%></td><td><%=rs.getString("S.st_banji")%></td><td><%=rs.getString("C.cj")%></td><td><%=rs.getString("C.xuenian")%></td><td><%=rs.getString("C.xueqi")%></td><td><a href="Updatacj.jsp?st_id=<%=rs.getString("S.st_id")%>&kc_id=<%=rs.getString("K.kc_id")%>">录入/修改学生成绩</a></td><td><a href="Selectanbj.jsp?st_banji=<%=rs.getString("S.st_banji")%>">按班级</a>&nbsp;&nbsp;&nbsp;<a href="Selectankc.jsp?kc_id=<%=rs.getString("K.kc_id")%>">按课程</a></td></tr>
		<%}
	
	%>
	</table>
	<jsp:include page="fy_cj.jsp"/>
</body>
</html>