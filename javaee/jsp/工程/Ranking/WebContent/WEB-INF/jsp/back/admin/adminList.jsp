<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ypy.dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ypy.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<%
		int currentpage = 1;
		if (request.getParameter("currentpage") != null) {
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}
		AdministratorDao admindao = new AdministratorDao();
		List<Administrator> list = admindao.adminList(currentpage);
		//request.setAttribute("list", list);
		//Iterator<Administrator> it = list.iterator();
		%>
		<c:set var="list" value="<%=list%>"></c:set>
		<table border="1">
			<tr><th>编号</th><th>姓名</th><th>密码</th></tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.username}</td>
					<td>${list.password}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="../paging.jsp">
		<jsp:param value="admin" name="status"/>  
		</jsp:include><br/>                    <!-- 往所包含的页面中传值，用于区分是普通用户的分页还是管理员的分页 -->
		<a href="JumpAdminAdd">添加管理员</a>
</body>
</html>