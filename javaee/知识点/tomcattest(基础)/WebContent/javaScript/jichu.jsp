<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javascript基础</title>

	<script language="javascript">
		var a = "你好，";
		a+="世界！";
		alert(a);
		
		function check()//函数
		{
			alert("此函数被调用！");
		}
	</script>
	
</head>
<body>
	<form>
		<input type="button" value="调用javaScript函数" onclick="check()"/>
	</form>
</body>
</html>