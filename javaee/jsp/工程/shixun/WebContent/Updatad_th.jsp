<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.teacher.*" %>
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
		Dao dao  = new Dao();
		Yh yh = new Yh();
		yh.setTh_id(request.getParameter("th_id"));
		ResultSet rs = dao.Selectid(yh);
		
		if (rs.next())// 必须有！！！！！！！！！！！！！！
		{
		
	%>
	<form action="Updata_th.jsp?th_id=<%=rs.getString("th_id") %>" method="post">
		<table>
			<tr><td>用户类型：</td><td><select name="th_type">
									      <option value="管理员">管理员</option>
									      <option value="普通用户">普通用户</option>
									  </select></td></tr>
			<tr><td><input type="submit" value="修改"></td><td><input type="reset" value="取消"></td></tr>
		</table>
	</form>
	<%
		}
	%>
	
</body>
</html>