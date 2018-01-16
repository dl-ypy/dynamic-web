<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.shixun.student.*" %>
<%@ page import="com.shixun.chengji.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
	<%
		request.setCharacterEncoding("utf-8");
		Daos daos = new Daos();
		Yhs yhs = new Yhs();
		yhs.setSt_banji(request.getParameter("st_banji"));
		yhs.setSt_xi(request.getParameter("st_xi"));
		yhs.setSt_id(request.getParameter("st_id"));
		yhs.setSt_name(request.getParameter("st_name"));
		yhs.setSt_sex(request.getParameter("st_sex"));
		Yhc yhc = new Yhc();
		yhc.setSt_id(request.getParameter("st_id"));
		yhc.setXuenian(request.getParameter("xuenian"));
		yhc.setXueqi(request.getParameter("xueqi"));
		int rs = daos.Insert(yhs);
		int rs1 = daos.Insertcj(yhc);
		if (rs!=0 && rs1!=0)
		{%>
			<jsp:forward page="Select_stg.jsp"/>
		<%}
		else
		{
			out.println("添加失败！");
		}
	%>
</body>
</html>