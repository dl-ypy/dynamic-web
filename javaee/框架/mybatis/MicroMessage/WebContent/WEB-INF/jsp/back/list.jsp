<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://localhost:8080/MicroMessage/js/jquery-3.1.0.min.js"></script>
<script src="http://localhost:8080/MicroMessage/js/list.js"></script>
</head>
<body>
	<form action="ListServlet" method="post" id="form">
		<input type="text" name="command"/>
		<input type="submit" value="查询"/><br/>
		
		<!-- post提交，需要调用javascript中的方法 -->
		<a href="javascript:deleteBatch();">通过复选框选中后批量删除</a>
		
	
		<table border="1" align="center">
			<tr><td></td><td>编号</td><td>指令</td><td>描述</td><td>回复</td><td>操作</td></tr>
			<c:forEach items="${messageList}" var="message" varStatus="status">
				<tr>
					<td><input type="checkbox" name="id" value="${message.id}"/></td>
					<td>${status.index+1}</td>
					<td>${message.command}</td>
					<td>${message.description}</td>
					<td>${message.content}</td>
					<td>
						<a href="DeleteOneServlet?id=${message.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</form>
</body>
</html>