<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.net.URLEncoder" %>   <%--引入包 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>写入</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String user = URLEncoder.encode(request.getParameter("user"), "utf-8");  //获取用户名
		Cookie cookie = new Cookie("mrCookie", user+"#"+new java.util.Date().toLocaleString());//创建并实例化cookie对象
		
		cookie.setMaxAge(60*60*24*30);  //设置cookie的有效期为30天
		response.addCookie(cookie);//保存cookie
	%>
	<script type="text/javascript">window.location.href="index.jsp"</script>
	
</body>
</html>