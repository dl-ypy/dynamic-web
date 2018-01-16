<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="loadXML.js"></script>
<script type="text/javascript" src="xpath.js"></script>
<script type="text/javascript">
	function testxpath() {
		var rootElement = loadXML(true, "xpath.xml");
		removeBlank(rootElement);
		//查找所有author元素节点
		//关键是如何表示元素节点在DOM树中的路径
		//绝对路径 /books/book/author
		//相对路径 book/author
		//全文搜索法 //author    //book/author
		var author1 = selectNodes(rootElement, "/books/book/author");
		var author2 = selectNodes(rootElement, "book/author");
		var author3 = selectNodes(rootElement, "//author");
		var author4 = selectNodes(rootElement, "//book/author");
		
		//查找属性节点
		//关键是先找到包含属性节点的元素节点
		var isdn1 = selectNodes(rootElement, "/books/book/@isdn");
		var isdn2 = selectNodes(rootElement, "book/@isdn");
		var isdn3 = selectNodes(rootElement, "//book/@isdn");
		var isdn4 = selectNodes(rootElement, "//books/book/@isdn");
		
		//查找文本节点
		//关键是找到包含文本节点的元素节点
		var text1 = selectNodes(rootElement, "/books/book/name/text()");
		var text2 = selectNodes(rootElement, "book/name/text()");
		var text3 = selectNodes(rootElement, "//name/text()");
		var text4 = selectNodes(rootElement, "//book/name/text()");
		
		//有条件的查找元素节点
		//首先找到元素节点，然后增加条件表达式
		var book1 = selectNodes(rootElement, "/books/book[@isdn]");
		var book2 = selectNodes(rootElement, "book[@isdn]");
		var book3 = selectNodes(rootElement, "//book[@isdn]");
		
		//多个条件和关系的查找元素节点(与关系)
		//首先找到元素节点，然后每一个查询条件写到一个中括号中
		var booka1 = selectNodes(rootElement, "/books/book[@isdn='0002'][price>35]");
		var booka2 = selectNodes(rootElement, "book[@isdn='0002'][price>35]");
		var booka3 = selectNodes(rootElement, "//book[@isdn='0002'][price>35]");
		
		//多个条件和关系的查找元素节点(或关系)
		//首先找到元素节点，然后每一个查询条件写到一个中括号中，用|连接起来
		var bookb1 = selectNodes(rootElement, "/books/book[@isdn='0002'] | /books/book[price>35]");
		var bookb2 = selectNodes(rootElement, "book[@isdn='0002'] | book[price>35]");
		var bookb3 = selectNodes(rootElement, "//book[@isdn='0002'] | //book[price>35]");
		alert("");
	}
	
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
	<input type="button" value="xpath查找" onclick="testxpath()">
</body>
</html>