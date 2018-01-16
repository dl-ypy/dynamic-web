<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	<s:form action="" method="post" theme="simple">   <!-- 注：这里要设置theme -->
		<s:text name="userName"></s:text>:<s:textfield name="username"></s:textfield><br/>   <!-- 这里的s:text name="userName"是取出国际化中的内容 -->
		<s:text name="passWord"></s:text>:<s:textfield name="password"></s:textfield><br/>
		<s:submit value="提交"></s:submit>
	</s:form>
	<a href="change?request_locale=zh_CN">中文</a><br/>
	<a href="change?request_locale=en_US">English</a>
  </body>
</html>
