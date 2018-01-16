<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test() {
		//JSON数据格式定义
		//数组
		var json1 = "[1,2,{" +
			"a:123,b:'String',c:[100,200]"
			+ "}]";
		var jsonArray = eval(json1);//转换为字符串
		
		//对象
		var json2 = "{" + 
			"a:'hello',b:[1,2,3],c:function(){alert(\"haha!\")}"
			+ "}"; 
		var jsonObject = eval("(" + json2 + ")");//对象转换为字符串格式比较特殊
		
		alert("");
	}
</script>
</head>
<body>
	<input type="button" value="json演示" onclick="test()"/>
</body>
</html>