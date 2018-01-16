<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>设置输出缓冲区的大小</title>
</head>
<body>
	<%
		response.setBufferSize(32);
		//设置缓冲区的大小为32KB
	%>
	<h1><b>通常情况下，服务器不会把要输出到客户端的内容直接写到客户端，而是先写到一个缓冲区。<br/>
	满足以下三种情况时，就会把缓冲区的内容写到服务器：<br/>
	1.jsp页面的信息以全部写到缓冲区。<br/>
	2.缓冲区以满。<br/>
	3.在jsp页面中调用了response对象的flushBuffer()方法或out对象的flush()方法。</b></h1>
</body>
</html>