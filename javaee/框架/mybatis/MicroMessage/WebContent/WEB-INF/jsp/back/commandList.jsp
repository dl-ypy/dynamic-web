<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CommandServlet" method="post" id="form">
		<input type="text" name="name"/>
		<input type="submit" value="查询"/><br/>
		
		<table border="1" align="center">
			<tr><td>指令编号</td><td>指令</td><td>内容编号</td><td>内容</td></tr>
			<c:forEach items="${commandlist}" var="command" varStatus="status">
				<tr>
					<td>${command.id}</td>
					<td>${command.name}</td>
					<td>
						<table>
							<c:forEach items="${command.list}" var="content" varStatus="status">
								<tr><td>${content.id}</td></tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table>
							<c:forEach items="${command.list}" var="content" varStatus="status">
								<tr><td>${content.content}</td></tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</form>
</body>
</html>