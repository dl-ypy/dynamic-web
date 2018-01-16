<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
  </head>
  
  <body>
    <button id="button1">ajax</button><br/>
    <button id="button2">ajax</button><br/>
    
    <script type="text/javascript">
    	
    	/* 原始方法 */
    	$(function() {
    		$("#button1").click(function(){
    			$.ajax({
    				type:"get",
    				url:"user/ajax.do",
    				data:"msg=ypy",
    				success:function(info){
    					alert(info);
    				}
    			});
    		});
    	});
    	
		$("#button2").click(function(){
			$.get("user/ajax.do",{msg:'ypy'},function(msg){
				alert(msg);
			});
		});
		
    	
    </script>
  </body>
</html>
