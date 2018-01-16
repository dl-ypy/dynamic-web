<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		用户名：<input type="text" name="username"/><br/>
		密码：<input type="password" name="password"/><br>
		性别：<input type="radio" name="sex" value="男"/>男
		    <input type="radio" name="sex" value="女"/>女<br/>
		电话：<input type="text" name="phone"/><br/>
		密保问题：<select name="security">
					<option value="question1">question1</option>
					<option value="question2">question2</option>
			   </select><br/>
		密保答案：<input type="text" name="answer"/><br/>
		邮箱：<input type="text" name="email"/><br/>
	         爱好：<input type="checkbox" name="hobby" value="篮球"/>篮球
	        <input type="checkbox" name="hobby" value="游泳"/>游泳<br/>
		<input type="submit" value="注册"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>