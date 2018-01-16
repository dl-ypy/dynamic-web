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
  	1.if语句：<br/>
    <s:set var="age" value="18"></s:set>
    <s:if test="#age==18">刚成年</s:if>
    <s:elseif test="#age>18">成年人</s:elseif>
    <s:else>未成年人</s:else><br/>
    2.循环语句<br/>
    <s:iterator begin="1" end="10" step="1" var="i" status="st">  <!-- 注：如果s:property中不写value，会自动取出值栈顶部的值 -->
    	<s:property value="#st.first"/> <!-- 判断是否是第一行 -->
    	<s:property value="#st.last"/>  <!-- 判断是否是最后一行 -->
    	<s:property value="#st.even"/>  <!-- 判断是否是偶数行 -->
    	<s:property value="#st.odd"/>  <!-- 判断是否是奇数行 -->
    	<s:property value="#i"/><br/>
    </s:iterator>
    <%
    	List<UserModel> list = new ArrayList<>();
    	list.add(new UserModel("张三"));
    	list.add(new UserModel("李四"));
    	list.add(new UserModel("王五"));
    	request.setAttribute("list", list);
     %>
     <!-- 增强型for循环 -->
     <s:iterator value="#request.list" var="user">
     	<s:property value="#user.username"/>
     	------------------------------------
     	<s:property value="username"/><br>    <!-- 增强版for循环中，会将对象的属性存放到值栈中 -->
     </s:iterator>
     3.%的使用<br/> <!--  %用来解决标签将OGNL表达式作为字符串处理的情况 -->
     <s:set var="url" value="'http://www.baidu.com'"></s:set>
     <s:property value="#url"/><br/>
     <s:property value="%{#url}"/><br/>
     4.日期时间类型<br/>
     <%request.setAttribute("now", new Date());%>
     <s:property value="#request.now"/><br/>
     <s:date name="#request.now" format="yyyy-MM-dd hh:mm:ss"/><br/>
    <s:debug></s:debug>
  </body>
</html>
