<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String yh = request.getParameter("yonghu");
		String mm1 = request.getParameter("mima1");
		String mm2 = request.getParameter("mima2");
		String dh = request.getParameter("dianhua");
		String yx = request.getParameter("youxiang");
		String xb = request.getParameter("xingbie");
		String jz = request.getParameter("juzhu");
		String jj = request.getParameter("jianjie");
		String ah[] = request.getParameterValues("del[]");//复选框的用数组
		
	%>

	用户：<%=yh%><br>
	密码：<%=mm1%><br>
	确认密码：<%=mm2%><br>
	电话号码：<%=dh%><br>
	邮箱：<%=yx%><br>
	性别：<%=xb%><br>
	居住地：<%=jz%><br>
	爱好：<%for(int i=0; i<ah.length; i++)
		{%>
			<%=ah[i]%>&nbsp;&nbsp;
		<%}%>
		<br>
	个人简介：<%=jj%><br>
	
	<form action="Shuaxin.jsp">
		<input type="submit" value="确定">
	</form>
	
</body>
</html>