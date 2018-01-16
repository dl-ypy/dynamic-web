<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			                   
			$.post("json.do",function(data){
				var html = "";
				for (var i=0; i<data.length; i++) {
					html+="<tr><td>"+ data[i].id +"</td><td>"+ data[i].name +"</td><td>"+ data[i].sex +"</td></tr>"
				}
				$("#context").html(html);
			});
		});
	});
</script>
</head>
<body>
	<input id="btn" type="button" value="获取数据"/><br/>
	<table width="80%" align="center">
		<tr><td>编号</td><td>姓名</td><td>性别</td></tr>
		
		<tbody id="context">
		</tbody>
	</table>
</body>
</html>