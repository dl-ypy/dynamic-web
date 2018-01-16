<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="DL" action="cx.jsp" method="post" target="_blank"><!--***********************************-->
						<table>
							<tr><td>用户名：</td> <td><input type="text" name="name" value=""/></td></tr>
							<tr><td>密码：</td> <td><input type="password" name="pas" value=""/></td></tr>
							<tr><td>用户身份：</td> <td>
									<select name="leixing">
										<option value="普通用户">普通用户</option>
										<option value="管理员">管理员</option>
									</select></td></tr>
							<tr><td><input type="submit" value="登陆"></td> <td><input type="reset" value="重置"><a href="Zhuce.jsp" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;注册</a></td></tr>
						</table>
					</form>
</body>
</html>