<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_update' starting page</title>
    
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
    <%-- <form action="user/user_update" method="post">
    	<input name="userid" type="hidden" value="${u.userid}"/><br/>
  		<input name="username" type="text" value="${u.username}"/><br/>
  		<input name="password" type="text" value="${u.password}"/><br/>
  		<input name="truename" type="text" value="${u.truename}"/><br/>
  		<input type="submit" value="提交"/>
  	</form> --%>
  	<s:form action="user_update" namespace="/user" method="post">
  		<s:hidden name="userid" value="%{userid}"></s:hidden>
  		<s:textfield name="username" label="用户名" value="%{username}"></s:textfield>
  		<s:textfield name="password" label="密码" value="%{password}"></s:textfield>
  		<s:textfield name="truename" label="真实姓名" value="%{truename}"></s:textfield>
  		<s:submit value="提交"></s:submit>
  	</s:form>
  </body>
</html>
