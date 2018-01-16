<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test() {
		//创建对象方式一
		var obj1 = new Object();
		//创建对象方式二
		var obj2 = {};
		
		//增加属性
		obj1.num = 1;
		obj1.str = "String";
		obj1.hello = function() {
			alert("hello");
		}
		obj2.obj = obj1;
		
		//访问属性方式一
		alert(obj2.obj.num);
		alert(obj2.obj.str);
		obj1.hello();
		//访问属性方式二
		alert(obj2["obj"]["num"]);
		alert(obj2["obj"]["str"]);
		obj1["hello"]();
		
		//对象直接量定义方法
		var obj3 = {
				num:1,
				str:"String",
				hello:function() {
					alert("hello");
				}
		}
		alert("");
	}
</script>
</head>
<body>
	<input type="button" value="对象演示" onclick="test()"/>
</body>
</html>