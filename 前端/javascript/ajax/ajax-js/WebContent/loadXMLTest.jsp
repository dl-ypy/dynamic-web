<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="loadXML.js"></script>
<script type="text/javascript">
	function test() {
		var domxml1 = loadXML(true, "test.xml");
		var domxml2 = loadXML(false, "<xml>6666</xml>");
		alert("");
	}
</script>
</head>
<body>
	<input type="button" value="装载XML" onclick="test()"/>
</body>
</html>