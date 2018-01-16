<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
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
		Dao dao = new Dao();
		List<Yh> list = new ArrayList<Yh>();
		list = dao.Select(currpage);
		Iterator<Yh> iter = list.iterator();
	%>
	<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
		<tr><th>编号</th><th>姓名</th><th>用户类型</th><th>性别</th><th>职位</th><th>联系方式</th><th>用户操作</th></tr>
		<%
		while (iter.hasNext())
		{
			Yh yh = iter.next();
		%>
			<tr><td><%=yh.getTh_id()%></td><td><%=yh.getTh_name()%></td><td><%=yh.getTh_type()%></td><td><%=yh.getTh_sex()%></td><td><%=yh.getTh_zhiwei()%></td><td><%=yh.getTh_phone()%></td><td><a href="Updatad_th.jsp?th_id=<%=yh.getTh_id()%>">修改</a>&nbsp;&nbsp;&nbsp;<a href="Delete_th.jsp?th_id=<%=yh.getTh_id()%>">删除</a></td></tr>
			<%
		}
	%>
	</table>
	<a href="Insertd_th.jsp">添加教师</a><br>
	<jsp:include page="fy_th.jsp"/><br>
</body>
</html>