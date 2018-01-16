<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xiangmu2.yh.*" %>
<%@ page import="com.xiangmu2.dao.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int currpage = 1;//这里要赋值当前页为1，下面再判断是否传来page1的值
		if (request.getParameter("page1") != null)
		{
			currpage = Integer.parseInt(request.getParameter("page1"));//request得到的是String类型的，要转换为int型
		}
		
		UserDao user = new UserDao();
		List<Yhgl> list = new ArrayList<Yhgl>();//创建对象
		list = user.Selectmy(currpage);					//调用方法
		Iterator<Yhgl> iter = list.iterator();  //迭代器
	%>
		<table border=1>
			<tr><th>编号</th><th>用户名</th><th>密码</th><th>用户类型</th><th>性别</th><th>电话</th><th>邮箱</th><th>住址</th><th>爱好</th><th>数据操作</th></tr>
			<%
				while (iter.hasNext())
				{
					Yhgl yh = iter.next();
				%>
				<tr><td><%=yh.getId()%></td><td><%=yh.getUsername()%></td><td><%=yh.getPassword() %></td><td><%=yh.getType()%></td><td><%=yh.getSex()%></td><td><%=yh.getPhone()%></td><td><%=yh.getYouxiang()%></td><td><%=yh.getAddress()%></td><td><%=yh.getLike()%></td><td>&nbsp;&nbsp;<a href="sql_update1.jsp?id=<%=yh.getId()%>">修改</a>&nbsp;&nbsp;<a href="sql_delete.jsp?id=<%=yh.getId() %>">删除</a></td></tr>
				<%--通过?传id值 --%>
			
			
		<% 
			}%>
		</table>   <!-- 表格必须把while语句包括进去 -->
		<jsp:include page="bar.jsp"/>
		<br>
		<a href="sql_insertd.jsp">添加用户</a>
</body>
</html>