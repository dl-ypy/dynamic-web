<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
         ��õķ���webԪ�صķ�����DI��IoC�� <br>
    <form name="f" action="" method="post">
    	������<input type="text" name="username"/><br/>
    	���룺<input type="password" name="password"/><br/>
    	<input type="button" value="��½" onclick="javascript:document.f.action='user/user';document.f.submit();"/><!-- ��javascriptָ��action·�� -->
    </form>
  </body>
</html>
