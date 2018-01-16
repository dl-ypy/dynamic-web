<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 要导入jQuery文件 -->
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#txtName").blur(function(){
			                   /* 参数 */
			$.post("ajax.do",{'name':$("#txtName").val()},function(data){
				alert(data);
			});
		});
	});
</script>
</head>
<body>
	用户名：<input id="txtName" type="text"/>
</body>
</html>