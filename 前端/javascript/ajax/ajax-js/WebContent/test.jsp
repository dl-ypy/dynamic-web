<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xmlhttp;//定义一个全局变量
	function submit() {
		//1.创建XMLHttpRequest对象
		if (window.XMLHttpRequest) {
			//IE7,IE8,FireFox,Mozilla,Safari,Opera等浏览器
			//alert("IE7,IE8,FireFox,Mozilla,Safari,Opera");
			xmlhttp = new XMLHttpRequest();
			if (xmlhttp.overrideMimeType) {//解决某些版本的浏览器在服务器端的响应没有"text/xml"头时，可能会出现错误的问题
				xmlhttp.overrideMimeType("text/xml");
			}
		} else if (window.ActiveXObject) {
			//IE6,IE5.5,IE5
			//alert("IE6,IE5.5,IE5");
			//为了满足各种客户的机器，这些浏览器需要进行尝试的创建XMLHttpRequest
			var activexName = ["MSXML2.XMLHTTP","Miscrosoft.XMLHTTP"];
			for (var i=0; i<activexName.length; i++) {
				try{
					xmlhttp = new ActiveXObject(activexName[i]);
					//直到创建成功为止
					break;
				} catch(e) {
					
				}
			}
		}
		
		if (xmlhttp==null) {
			alert("当前浏览器不支持创建XMLHttpRequest对象，请更换浏览器！");
			return;
		}
		
		//2.注册回调方法
		xmlhttp.onreadystatechange = callback;
		//错误的写法：xmlhttp.onreadystatechange = callback();
		
		var username = document.getElementById("username").value;
		username = encodeURI(encodeURI(username));//解决乱码问题
		
		/* //GET方式交互 
		//3.设置和服务器端交互的相应参数
		xmlhttp.open("GET", "AJAX?name=" + username, true);//设置为true表示异步交互
		
		//4.设置向服务器端发送的数据，启动和服务器端的交互
		xmlhttp.send(null);  */ 
		
		 //POST方式交互
		//3.设置和服务器端交互的相应参数
		xmlhttp.open("POST", "AJAX", true);//设置为true表示异步交互
		//POST方式交互需要增加的代码
		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//4.设置向服务器端发送的数据，启动和服务器端的交互
		xmlhttp.send("name=" + username); 
	}
	
	function callback() {
		//5.判断和服务器端的交互是否完成,判断服务器端是否正确返回数据
		if (xmlhttp.readyState == 4) {
			//表示和服务器的交互已经完成
			if (xmlhttp.status == 200) {
				//服务器的响应代码是200，正确返回了数据
				var message = xmlhttp.responseText;
				//XML数据对应的DOM对象的接受方法
				//使用的前提是，服务器端需要设置content-type为text/xml
				//var domXml = xmlhttp.responseXML;
				
				//向div标签中填充文本内容
				var div = document.getElementById("message");
				div.innerHTML = message;
			}
		}
	}
</script>
</head>
<body>
	<input type="text" id="username"/>
	<input type="button" onclick="submit()" value="验证用户名"><br/>
	<div id="message"></div>
</body>
</html>






















