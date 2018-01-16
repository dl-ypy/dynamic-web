<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>操作文档实现添加，删除评论</title>

	<script language="javaScript">
		//添加评论
		function addElement()
		{
			var person = document.createTextNode(form.person.value);//创建代表评论人的TextNode节点
			var content = document.createTextNode(form.content.value);//创建代表评论内容的TextNode节点
			
			//创建td类型的Element结点
			var td_person = document.createElement("td");
			var td_content = document.createElement("td");
			var tr = document.createElement("tr");//创建一个tr类型的Element结点
			var tbody = document.createElement("tbody");//创建一个tbody类型的Element结点
			
			//将TextNode结点加到td类型结点中
			td_person.appendChild(person);//添加评论人
			td_content.appendChild(content);//添加评论内容
			
			//将td类型结点添加到tr结点中
			tr.appendChild(td_person);
			tr.appendChild(td_content);
			
			tbody.appendChild(tr);//将tr结点添加到tbody中
			var tComment = document.getElementById("comment");//获取table对象
			tComment.appendChild(tbody);//将tbody结点加到结点尾部
			
			//清空文本框
			form.person.value = "";
			form.content.value = "";
		}
		
		//删除第一条评论
		function deleteFirstE()
		{
			var tComment = document.getElementById("comment");//获取table对象
			if (tComment.rows.length > 1)
			{
				tComment.deleteRow(1);//删除表格第二行，即评论第一条
			}
		}
		
		//删除最后一条评论
		function deleteLastE()
		{
			var tComment = document.getElementById("comment");//获取table对象
			if (tComment.rows.length > 1)
			{
				tComment.deleteRow(tComment.rows.length-1);//删除表格最后一行，即评论最后一条
			}
		}
		
	</script>
	
</head>
<body>
	<table width="600" border="1" align="center" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#FFFFFF" id="comment">
		<tr>
			<td width="18%" height="27" align="center" bgcolor="#E5BB93">评论人</td>
			<td width="82%" align="center" bgcolor="#E5BB93">评论内容</td>
		</tr>
	</table>
	
	<form name="form" method="post" action="">
		<table align="center">
			<tr><td>评论人：</td><td><input type="text" name="person" id="person" size="40"/><br/></td></tr>
			<tr><td>评论内容：</td><td><textarea name="content" cols="60" rows="6" id="content"></textarea></td></tr>
			<tr><td><input name="Button" type="button" value="发表" onclick="addElement()"><input type="reset" value="重置"></td>
			<td><input name="Button" type="button" value="删除第一条评论" onclick="deleteFirstE()"><input name="button" type="button" value="删除最后一条评论" onclick="deleteLastE()"></td></tr>
		</table>
	</form>
</body>
</html>