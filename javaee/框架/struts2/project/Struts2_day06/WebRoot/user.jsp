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
  	<!-- <form action="user/user_save" method="post">
  		<input name="username" type="text"/><br/>
  		<input name="password" type="text"/><br/>
  		<input name="truename" type="text"/><br/>
  		<input type="submit" value="提交"/>
  	</form> -->
  	<s:actionerror/>
  	<s:form action="user_save" namespace="/user" method="post">
  		<s:textfield name="username" label="用户名"></s:textfield>
  		<s:textfield name="password" label="密码"></s:textfield>
  		<s:textfield name="truename" label="真实姓名"></s:textfield>
  		<s:submit value="提交"></s:submit>
  	</s:form>
    <%-- <c:forEach var="user" items="${list}">
    	${user.userid}---${user.username}---${user.password}---${user.truename}<a href="user/user_delete?userid=${user.userid}">删除</a>&nbsp;&nbsp;<a href="user/user_updatePage?userid=${user.userid}">修改</a><br/>
    </c:forEach> --%>
    <s:iterator value="list" var="user">
    	<s:property value="userid"/>---
    	<s:property value="username"/>---
    	<s:property value="password"/>---
    	<s:property value="truename"/>
    	<a href="user/user_delete?userid=${user.userid}">删除</a>&nbsp;&nbsp;
    	<a href="user/user_updatePage?userid=${user.userid}">修改</a><br/>
    </s:iterator>
  </body>
</html>
