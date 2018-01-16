<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
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
   request作用域 ${requestScope.msg } <br>
   session作用域 ${sessionScope.msg } <br>
   application作用域 ${applicationScope.msg } <br>
   ${msg }
   <br/>
   OGNL获取的request作用域 <s:property value="#request.msg"></s:property><br />
   OGNL获取的session作用域<s:property value="#session.msg"></s:property><br />
   OGNL获取的application作用域<s:property value="#application.msg"></s:property><br />
   <s:property value="#attr.msg"/>
   OGNL获取属性驱动的值<br/>用户名<s:property value="model.username"/><br />
   OGNL获取模型驱动的值<br/>用户名<s:property value="username"/><br/>   <!-- 注：如果action中的属性与action中对象属性的属性相同，且都有值，在值栈中，对象的属性位于顶部，所以取出是对象的属性 -->
   OGNL调用方法:<s:property value="say()"></s:property><br>
   OGNL调用静态属性值:<s:property value="@com.ypy.struts2.action.Content@name"  ></s:property><br>
   OGNL调用静态属性方法:<s:property value="@com.ypy.struts2.action.Content@hello()"  ></s:property><br>
   <s:property value="#"/>
	投影和选择（集合操作）
	<s:property value="list"/><br/>
	<s:property value="$#list.username=='张三'"/><br/>
	<s:property value="^#list.username=='张三'"/><br/>
	<s:property value="?#list.username=='张三'"/><br/>
	<s:debug></s:debug>
  </body>
</html>
