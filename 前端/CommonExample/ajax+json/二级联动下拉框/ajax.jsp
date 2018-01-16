<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<select name="id" onchange="changeCity(this.value)">
			<option value="0">请选择省份</option>
			<option value="1">山西</option>
			<option value="2">山东</option>
			<option value="3">陕西</option>
		</select>
		
		<select id="city">
			<option value="0">请选择城市</option>
		</select>
		
	<script type="text/javascript">
		function changeCity(val) {
			//获取XMLHttpRequest对象
			var xmlhttp = new XMLHttpRequest();
			//打开连接通道
			xmlhttp.open("POST", "JsonServlet?id="+val, true);
			//发送请求
			xmlhttp.send();
			xmlhttp.onreadystatechange = function() {
				var city = document.getElementById("city");
				city.length = 1;
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					var date = eval(xmlhttp.responseText);
					for (var i=0; i<date.length; i++) {
						var option = document.createElement('option');
						option.innerHTML = date[i].name;
						city.appendChild(option);
					} 
				}
			}
		}
	</script>
</body>
</html>