<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ypy.dao.*" %>
<%@ page import="com.ypy.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
</head>
<body>
	<!-- 分页的jsp -->
	<%
		String status = request.getParameter("status");//用户身份
		int currentPage = 1;
		String filename = null;
		if (request.getParameter("currentpage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentpage"));
		}
		PagingDao pagingdao = new PagingDao();
		int allrecords = pagingdao.getAllRecords(status);
		PagingService pagingservice = new PagingService();
		int allpages = pagingservice.getAllPages(allrecords);
		filename = pagingservice.getFileName(status);
		if (currentPage == 1) {
			out.println("首页");
			out.println("上一页");
		} else {
			out.println("<a href='Jump" + filename + "List?currentpage="+1+"'>首页</a>");
			out.println("<a href='Jump" + filename + "List?currentpage="+(currentPage-1)+"'>上一页</a>");
		}
		for (int i=1; i<=allpages; i++)
		{
			if (i == currentPage)//如果是当前页直接追加，不加超链接
			{
				out.println(i);  //追加i的值
			}
			else
			{
				out.println("<a href='Jump" + filename + "List?currentpage="+i+"'>"+i+"</a>");//不是当前页的要加超链接
			}
			out.println(" ");
		}
		if (currentPage == allpages) {
			out.println("下一页");
			out.println("尾页");
		} else {
			out.println("<a href='Jump" + filename + "List?currentpage="+(currentPage+1)+"'>下一页</a>");
			out.println("<a href='Jump" + filename + "List?currentpage="+allpages+"'>尾页</a>");
		}
	%>
</body>
</html>