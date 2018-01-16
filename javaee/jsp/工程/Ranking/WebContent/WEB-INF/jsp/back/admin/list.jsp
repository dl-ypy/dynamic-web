<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ypy.dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ypy.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<%
		int currentPage = 1;
		if (request.getParameter("currentpage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentpage"));
		}
		UserDao userdao = new UserDao();
		List<User> list = userdao.userSelect(currentPage);
		//request.setAttribute("list", list);
		//Iterator<User> it = list.iterator();
		%>
		<c:set var="list" value="<%=list%>"></c:set>
		<table border="1">
			<tr><th>编号</th><th>姓名</th><th>密码</th><th>性别</th><th>爱好</th><th>操作用户数据</th></tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.username}</td>
					<td>${list.password}</td>
					<td>${list.sex}</td>
					<td>${list.hobby}</td>
					<td><a href="UserRemoveServlet?id=${list.id}">删除用户</a></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="../paging.jsp">
		<jsp:param value="user" name="status"/>
		</jsp:include><br/>
		<a href="JumpAdminAdd">添加管理员</a><br/>
		<a href="JumpAdminList?currentpage=1">查询管理员</a>
</body>
</html>