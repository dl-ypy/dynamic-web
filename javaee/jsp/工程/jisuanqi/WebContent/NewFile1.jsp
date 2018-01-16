<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>计算器</title>
<script type="text/javascript" src="js/js1.js"></script>
			<%--需要引入文件 --%>
</head>
<body>
	<form action="jieguo.jsp" method="post" onSubmit="return checknum()">
		请输入第一个数：<input name="num1" id="num1" type="text" value=""/><br>
		请输入第二个数：<input name="num2" id="num2" type="text" value=""/><br><!-- 通过id传值 -->
		请选择操作符：&nbsp;&nbsp;&nbsp;<select name="czf">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select><br>
		<input type="submit" value="计算"/>
	</form>
</body>
</html>