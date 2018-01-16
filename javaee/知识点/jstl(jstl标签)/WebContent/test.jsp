<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10">  <!-- 循环1-10 -->
		${i}
	</c:forEach><br/>
	***************************<br/>
	<%
		List list = new ArrayList();
		list.add(50);
		list.add(150);
		list.add(250);
		session.setAttribute("list", list);
	%>
	<c:forEach var="e" items="${list}">  <!-- 相当于增强型for循环 -->
		${e}
	</c:forEach><br/>
	***************************<br/>
	<%
		Map map = new HashMap();
		map.put("n", 9);
		map.put("m", 90);
		map.put("q", 900);
		session.setAttribute("map", map);
	%>
	<c:forEach var="entry" items="${map}">  <!-- map的循环 -->
		${entry.key} = ${entry.value}<br/>
	</c:forEach>
	***************************<br/>
	<%
		//request.setAttribute("i", 5);
	%>
	<c:set var="i" value="5" scope="request"/>  <!-- 代替上面的request.setAttribute("i", 5); 如果不写scope="request，默认为放到page下-->
	${i}>0?
	<c:if test="${i>0}">   <!-- if语句，无else -->
		true
	</c:if>
	<c:if test="${i<=0}">
		false
	</c:if><br/>
	***************************<br/>
	<%
		request.setAttribute("date", new Date());
	%>
	date = <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${date}"/>  <!-- 用fmt来控制日期格式 -->
</body>
</html>