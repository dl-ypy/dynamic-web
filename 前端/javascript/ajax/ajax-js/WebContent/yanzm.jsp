<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成验证码</title>
<script type="text/javascript">
	function change() {
		var imgNode = document.getElementById("vimg");
		imgNode.src = "GetImages";
		imgNode.src = "GetImages?t=" + (new Date()).valueOf();//加时间戳，避免在更换图片时浏览器认为是重复操作，而读取了缓存	                                                      //加上时间戳就使得每次的提交都不同
	}
</script>
</head>
<body>
	<img alt="验证图片" src="GetImages" id="vimg"/><input type="button" value="换一种图片" onclick="change()"/>
</body>
</html>