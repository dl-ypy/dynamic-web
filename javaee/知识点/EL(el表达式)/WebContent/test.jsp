<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ypy.el.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL表达式</title>
</head>
<body>
	<%
		String name = "ypy";
		request.setAttribute("name1", name);//必须将变量放到一种范围变量中
	%>
	name = ${name1}<br/>
	*******************************<br/>
	name = ${ypy}<br/>    <!-- 即使没有定义变量，也不会等于null，不会产生空指针错误 -->
	*******************************<br/>
	<!-- 输入以下地址，传入参数
	http://localhost:8080/EL/test.jsp?num=5&num1=9 -->
	num = ${param.num}<br/>   <!-- 要想得到传过来的参数，必须加param -->
	num + num1 = ${param.num + param.num1}<br/>
	*******************************<br/>
	password是否为空? ${empty password}<br/>   <!-- 可以直接判断是否为空 -->
	<%
		List<String> list = new ArrayList<String>();
	%>
	list是否为空? ${empty list}<br/>   <!-- 这里是判断集合里面是否有元素，所以这里也为空 -->
	*******************************<br/>
	\${3+2-1} = ${3+2-1}<br/>    <%-- 要想在页面上显示出${3+2-1}，必须加"\" --%>
	*******************************<br/>
	<%
		User user = new User("ypy", "123");
		request.setAttribute("user", user);//将这个对象整体放入request中
	%>
	User:<br/>
	name = ${user.name}, pass = ${user.pass}<br/>
	*******************************<br/>
	<%
		pageContext.setAttribute("scope", "page");
		request.setAttribute("scope", "request");
		session.setAttribute("scope", "session");
		application.setAttribute("scope", "application");
	%>
	scope = ${scope}<br/>   <!-- 默认为显示范围最小的 -->
	scope = ${sessionScope.scope}<br/>
	*******************************<br/>
	<%
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		session.setAttribute("list1", list1);
		
		Map map = new HashMap();
		map.put("yang", 10);
		map.put("wang", 20);
		map.put("zhang", 80);
		session.setAttribute("map", map);
	%>
	list1 = ${list1[0]}, ${list1[1]}, ${list1[2]}<br/>  <!-- 取集合中值的方式 -->
	map = ${map.zhang}, ${map.yang}, ${map.wang}<br/>  <!-- 取map中值的方式 -->
	map = ${map["zhang"]}, ${map["wang"]}, ${map["yang"]}
</body>
</html>