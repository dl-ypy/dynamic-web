<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="loadXML.js"></script>
<script type="text/javascript">
	function test() {
		var rootElement = loadXML(true, "TestBook.xml");
		alert(serializeDOM(rootElement));
		removeBlank(rootElement);
		alert(serializeDOM(rootElement));
		var rootDocument = rootElement.parentNode;
		var bookElement = rootDocument.createElement("book");
		var textNode = rootDocument.createTextNode("AJAX Hello");
		bookElement.appendChild(textNode);
		rootElement.appendChild(bookElement);
		alert(serializeDOM(rootElement));
		var bookElements = rootElement.getElementsByTagName("book");
		alert("");
	}
	
	//封装不同浏览器序列化DOM对象为XML字符串的方法
	function serializeDOM(xmldoc) {
		if (xmldoc.xml) {
			return xmldoc.xml;
		} else if(window.XMLSerializer) {
			var seria = new XMLSerializer();
			return seria.serializeToString(xmldoc);
		}
		return null;
	}
	
	//去除firefox中的空白节点
	function removeBlank(doc) {
		if (doc.childNodes.length > 1) {
			for (var loopIndex=0; loopIndex<doc.childNodes.length; loopIndex++) {
				var currentNode = doc.childNodes[loopIndex];
				if (currentNode.nodeType == 1) {
					removeBlank(currentNode);
				}
				if (currentNode.nodeType==3 && (/^\s+$/.test(currentNode.nodeValue))) {
					doc.removeChild(doc.childNodes[loopIndex--]);
				}
			}
		}
	}
</script>
</head>
<body>
	<input type="button" onclick="test()" value="操作XML"/>
</body>
</html>