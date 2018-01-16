<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DOM树</title>
<script type="text/javascript">
	function testapi() {
		//获取根元素节点
		var htmlrootElement = document.documentElement;
		
		//获取指定的元素节点
		var divNode = document.getElementById("div1");
		
		//获取整个页面的div节点
		var divNodes = document.getElementsByTagName("div");
		
		//创建元素节点
		var newDivNode = document.createElement("div");
		
		//创建文本节点
		var newTextNode = document.createTextNode("aaa");
		
		//返回大写的标签名
		var tagname = divNode.tagName
		
		//根据标签名获取元素节点
		var divNode2 = document.getElementById("div2");
		var divNodes2 = divNode2.getElementsByTagName("div");
		
		//操作属性
		/* var inputtext = document.getElementById("inputtext");
		var flag = inputtext.hasAttribute("value");
		inputtext.setAttribute("value", "textetext");
		var textValue = inputtext.getAttribute("value");
		inputtext.removeAttribute("value"); */
		
		//另一种操作元素属性的方法  常用
		inputtext.value = "123222";
		var textValue2 = inputtext.value;
		
		var clic = document.getElementById("clic");
		clic.onclick = function() {alert("666")}
		
		//返回元素节点包含的属性节点
		var attributes = inputtext.attributes;
		
		var inputName = inputtext.nodeName;
		var nodetype = inputtext.nodeType;
		var nodevalue = inputtext.nodeValue;
		
		//获取divNode2的所有子节点
		var childs = divNode2.childNodes;
		//获取divNode2的父节点
		var parent = divNode2.parentNode;
		//获取第一个节点和最后一个节点
		var first = divNode2.firstChild;
		var last = divNode2.previousSibling;
		//获取兄弟节点
		var next = divNode2.nextSibling;
		var last = divNode2.previousSiling;
		
		//判断是否有子节点
		var flag2 = divNode2.hasChildNodes();
		//追加节点
		newDivNode.appendChild(newTextNode);
		divNode2.appendChild(newDivNode);
		var new2 = document.createElement("div");
		var text2 = document.createTextNode("insert");
		new2.appendChild(text2);
		divNode2.insertBefore(new2, divNode2.firstChild);
		var new3 = document.createElement("div");
		var text3 = document.createTextNode("insert3");
		new3.appendChild(text3);
		divNode2.insertBefore(new3, null);
		divNode2.insertBefore(new3, divNode2.firstChild);
		
		//移除节点
		var remove = divNode2.removeChild(new3);
		//替换节点
		var new4 = document.createElement("div");
		var text4 = document.createTextNode("insert4");
		new4.appendChild(text4);
		var replace = divNode2.replaceChild(new4, divNode2.getElementsByTagName("div")[0]);
		//如果第一个参数是当前节点的子节点，那么这个参数对应的节点将会被移动到第二个参数对应的节点的位置
		//第二个参数所对应的节点就被删除了
		var replace2 = divNode2.replaceChild(newDivNode, divNode2.getElementsByTagName("div")[0]);
		
		//克隆节点
		var clone1 = divNode2.cloneNode(true);
		var clone2 = divNode2.cloneNode(false);
		
		alert("");
	}
</script>
</head>
<body>
	<input type="button" value="TestDomAPI" onclick="testapi()"/>
	<div id="div1">123123</div>
	<input type="text" id="inputtext"/>
	<div id="div2">
		456
		<div>789</div>
	</div>
	<input type="button" id="clic" value="test"/>
</body>
</html>























