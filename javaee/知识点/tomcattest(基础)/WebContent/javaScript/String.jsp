<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>String对象，对字符串的一些操作</title>

	<script language="javaScript">
	var str = "2016-6-12";
	var arr = str.split("-");//用“-”分割数组
	document.write("字符串"+str+"进行分割后的数组为：<br/>");//按html的格式读取
	for (i=0; i<arr.length; i++)
	{
		document.write("arr["+i+"]:"+arr[i]+"<br/>");
	}
		
		function trim()
		{
			var str1 = form.oldString.value;
			if (str1 == "")
			{
				alert("请输入原字符串");
				form.oldString.focus();
				return;
			}
			else
			{
				var str2 = /(^\s*)|(\s*$)/g;  //创建RegExp对象
				str1 = str1.replace(str2, "");//替换首尾空格
			}
			form.newString.value = str1;//将替换后的写到文本域中
		}
	</script>
	
</head>
<body>
	<br/>
	<form name="form" action="" method="post">
		<table>
			<tr><td>原字符串：</td>
			<td><textarea name="oldString" cols="40" rows="4"></textarea></td></tr>
			<tr><td>转换后的字符串：</td>
			<td><textarea name="newString" cols="40" rows="4"></textarea></td></tr>
			<tr><td><input type="button" value="去掉字符串的首尾空格" onclick="trim()"></td></tr>
		</table>
	</form>
</body>
</html>