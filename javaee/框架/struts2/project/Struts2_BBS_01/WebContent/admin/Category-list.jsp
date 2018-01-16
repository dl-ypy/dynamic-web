<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 能传参数的I18N -->
	<s:text name="welcome.msg">
		<s:param>ypy</s:param><!-- 也可以在s:param中用value=""，传一个变量参数 -->
	</s:text>
	<hr/>
	<a href="http://localhost:8080/Struts2_BBS_01/admin/Category-addInput">添加</a>
	<hr/>
	<s:iterator value="categories" var="c">
		<s:property value="#c.name"/>|
		<s:property value="#c.description"/>|
		<a href="http://localhost:8080/Struts2_BBS_01/admin/Category-delete?id=<s:property value="#c.id"/>">删除</a>
		<a href="http://localhost:8080/Struts2_BBS_01/admin/Category-updateInput?id=<s:property value="#c.id"/>">更新</a><br/>
	</s:iterator>
	<a href="http://localhost:8080/Struts2_BBS_01/admin/index?request_locale=en_US">en</a><!-- 后面传参数可转换中英文 -->
	<a href="http://localhost:8080/Struts2_BBS_01/admin/index?request_locale=zh_CN">ch</a>
	<s:debug></s:debug>
</body>
</html>
















