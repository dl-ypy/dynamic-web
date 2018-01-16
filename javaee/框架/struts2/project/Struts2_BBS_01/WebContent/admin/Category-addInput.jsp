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
	<form action="admin/Category-add" method="post">
		<!-- 这里是I18N国际化 -->
		<!-- action级别的   资源文件的首单词必须与action文件名相同 -->
		<!-- action级别的资源文件已经删除 -->
		<s:property value="getText('login.username')"/><input type="text" name="category.name" value=""/>
		<s:property value="getText('login.password')"/><input type="text" name="category.description" value=""/>
		<input type="submit" value="<s:property value="getText('login.add')"/>"/>
	</form>
	<s:debug></s:debug>
</body>
</html>