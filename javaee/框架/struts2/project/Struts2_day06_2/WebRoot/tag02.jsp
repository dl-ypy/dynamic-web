<%@page import="com.ypy.struts2.model.UserModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
  	<%-- <s:form action="" method="" enctype="" theme="simple">
  		用户名：<s:textfield name="username"></s:textfield>
  		密码：<s:textfield name="password"></s:textfield>
  	</s:form> --%>
  	<s:form action="" method="" enctype="">
  		<s:textfield name="username" label="用户名"></s:textfield>
  		<s:textfield name="password" label="密码"></s:textfield>
  		<s:radio list="#{1:'男',2:'女'}" name="sex" value="1" label="性别"></s:radio>   <!-- 注：name属性必写 -->
  		<s:checkboxlist list="#{'a':'A','b':'B','c':'C'}" name="game" label="游戏" value="{'a','b','c'}"></s:checkboxlist>
  		<s:select list="#{1:'北京',2:'上海',3:'深圳'}" name="city" label="城市" value="2"></s:select>
  		<s:file name="file" label="图片"></s:file>
  		<s:submit value="提交"></s:submit>
  	</s:form>
    <s:debug></s:debug>
  </body>
</html>
