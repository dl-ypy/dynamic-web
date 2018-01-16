<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String czf = request.getParameter("czf");
    double jg = 0;
    
    double d_num1 = Double.parseDouble(num1);
    double d_num2 = Double.parseDouble(num2);
    
    if (czf.equals("+"))
    {
    	jg = d_num1 + d_num2;
    }
    else if (czf.equals("-"))
    {
    	jg = d_num1 - d_num2;
    	
    }
    else if (czf.equals("*"))
    {
    	jg = d_num1 * d_num2;
    }
    else
    {
    	jg = d_num1 / d_num2;
    }
	    
	    out.println("结果是："+jg);
	%>
</body>
</html>