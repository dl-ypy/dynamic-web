<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xiangmu2.yh.*" %>
<%@ page import="com.xiangmu2.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	
	<%
		request.setCharacterEncoding("utf-8");
		Yhgl yh = new Yhgl();
		UserDao user = new UserDao();
		yh.setId(request.getParameter("id"));
		ResultSet rs = user.Select_id(yh);
		
		if (rs.next())
		{
	%>
		<form action="sql_update2.jsp?id=<%=rs.getString("id")%>" method="post">
		<table>
			<tr><td>用户名：</td> <td><input type="text" name="username" value="<%=rs.getString("username")%>"></td></tr>
			<tr><td>密码：</td> <td><input type="text" name="password" value="<%=rs.getString("password")%>"></td></tr>
			<tr><td>用户类型：</td><td>
				<select name="type">
					<option value="管理员">管理员</option>
					<option value="普通用户">普通用户</option>
				</select></td></tr>
			<tr><td>性别：<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女</td></tr>
            <tr><td>电话号码:</td> <td><input type="text" name="phone" value="<%=rs.getString("phone")%>"></td></tr>
            <tr><td>邮箱:</td> <td><input type="text" name="youxiang" value="<%=rs.getString("youxiang")%>"></td></tr>
            <tr><td>居住地：</td> <td>
				<select name="address" >
					<option value="北京">北京</option>
					<option value="山西">山西</option>
					<option value="河南">河南</option>
					<option value="山东">山东</option>
					<option value="广东">广东</option>
					<option value="上海">上海</option>
					<option value="东北">东北</option>
	
				</select></td></tr>
			<tr><td><input type="submit" value="修改">&nbsp;&nbsp;<input type="reset" value="取消"></td></tr>
		</table>
		</form>
		<%
		}
		%>
</body>
</html>