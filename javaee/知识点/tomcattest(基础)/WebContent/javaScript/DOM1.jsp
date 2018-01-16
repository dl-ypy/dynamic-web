<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>判断文档标记个数</title>
</head>

	<script language="javaScript">
		var elementList = "";  //全局变量，保存标记名
		function getElement(node)//参数node是一个Node对象
		{
			var total = 0;
			if (node.nodeType == 1)//检查node是否为Element对象
			{
				total++;//如果是，计数器加一
				elementList = elementList + node.nodeName + "、";//保存标记名 
			}
			for (var m=node.firstChild; m!=null; m=m.nextSibling)
			{
				total += getElement(m);//对每个子结点进行递归操作
			}
			return total;
		}
		
		function show()
		{
			var number = getElement(document);//获取标记总数
			elementList = elementList.substring(0, elementList.length-1);//去除字符串最后一个逗号
			alert("该文档中包含："+elementList+"等"+number+"个标记！");
			elementList = "";//最后清空全局变量
		}
	</script>
	
<body onload="show()">
	<%--调用show方法 --%>
	<br/>
	<h1><b><i><u><a href="#">判断标记个数</a></u></i></b></h1>

</body>
</html>