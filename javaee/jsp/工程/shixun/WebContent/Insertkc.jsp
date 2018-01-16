<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<form action="DoInsertkc.jsp" method="post">
      <table>
	<tr><td>选修课名称：</td><td><input type="text" name="kc_name" value=""/></td></tr>
	<tr><td>教师编号：</td><td><input type="text" name="th_id" value=""></td></tr>
	<tr><td>选修课教室：</td><td><input type="text" name="kc_address" value=""></td></tr>
	
	<tr><td><input type="submit" value="添加"></td><td><input type="reset" value="重置"></td></tr>
         </table>  
    
</form>
</body>
</html>