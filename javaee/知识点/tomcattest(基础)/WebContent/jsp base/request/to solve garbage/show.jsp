<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	name参数的值为：<%=new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8")%><br/>
	sex参数的值为：<%=new String(request.getParameter("sex").getBytes("ISO-8859-1"), "utf-8")%>
	<%--因为所有的request请求都是ISO-8859-1的，在此处通过String的构造方法按指定的编码方式->“utf-8”重新构造一个String对象即可 --%>
</body>
</html>