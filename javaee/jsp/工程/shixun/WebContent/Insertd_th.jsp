<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<form name="DL" action="Insert_th.jsp" method="post" target="_blank">
						<table>
							<tr><td>姓名：</td> <td><input type="text" name="th_name" value=""/></td></tr>
							<tr><td>用户类型：</td> <td>
									<select name="th_type">
										<option value="普通用户">普通用户</option>
										<option value="管理员">管理员</option>
									</select></td></tr>
							<tr><td>职位：</td> <td><input type="text" name="th_zhiwei" value=""/></td></tr>
			                <tr><td>性别:</td> <td><input type="radio" name="th_sex" value="男">男
			                <input type="radio" name="th_sex" value="女">女</td></tr>
							<tr><td><input type="submit" value="添加"></tr>
						</table>
					</form>
</body>
</html>