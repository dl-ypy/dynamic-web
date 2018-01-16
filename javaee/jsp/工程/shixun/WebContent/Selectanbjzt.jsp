<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.chengji.*" %>
<%@ page import="java.sql.*" %>
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
		request.setCharacterEncoding("utf-8");
		Daoc daoc = new Daoc();
		Yhc yhc = new Yhc();
		yhc.setSt_banji(request.getParameter("st_banji"));
		ResultSet rs = daoc.Selectanxszt(yhc);
		out.println(request.getParameter("st_banji")+"班的整体成绩如下！");
		if (rs.next())
		{%>
		<table border="5" bordercolor="#00FFFF" cellspacing="0" bgcolor="#CCCCCC">
			<tr><th>总分</th><th>平均分</th><th>最低分</th><th>最高分</th></tr>
			<tr><td><%=rs.getString("sum(C.cj)")%></td><td><%=rs.getString("avg(C.cj)")%></td><td><%=rs.getString("max(C.cj)")%></td><td><%=rs.getString("min(C.cj)")%></td></tr>
		</table>
		<%}
	%>

</body>
</html>