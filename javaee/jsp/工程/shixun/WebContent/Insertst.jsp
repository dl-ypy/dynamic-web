<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
		#zc1{
			width:300px;
			margin:0px auto;
		}
	</style>
	<script language="javascript">
		function check(zclist){
		var st_name=zclist.st_name.value;
		var st_xi=zclist.st_xi.value;
		var st_id=zclist.st_id.value;
		var st_sex=zclist.st_sex.value;
		var st_banji=zclist.st_banji.value;
		var xuenian=zclist.xuenian.value;
		var xueqi=zclist.xueqi.value;
		
		if(st_id==""){
			alert("学号不能为空！");zclist.st_id.focus();zclist.st_id.select();return false;
		}
		if(st_name==""){
			alert("姓名不能为空！");zclist.st_name.focus();zclist.st_name.select();return false;
		}
		if(st_sex==""){
			alert("性别不能为空！");zclist.st_sex.focus();zclist.st_sex.select();return false;
			}
		if(st_banji==""){
			alert("班级不能为空！");zclist.st_banji.focus();zclist.st_banji.select();return false;
			}
		if(st_xi==""){
			alert("系不能为空！");zclist.st_xi.focus();zclist.st_xi.select();return false;
			}
		if(xuenian==""){
			alert("学年不能为空！");zclist.xuenian.focus();zclist.xuenian.select();return false;
			}
		if(xueqi==""){
			alert("学期不能为空！");zclist.xueqi.focus();zclist.xueqi.select();return false;
			}
		return true;
		
		}
	</script>
</head>
<body style="background:url(images/14.jpg)">
<%
		if (session.getAttribute("name") == null)
		{
			response.sendRedirect("Shouye.jsp");
		}
	%>
<br><br><br><br><br><br><h1 align="center"><b>添加学生</b></h1>
	<div id=zc1>
		<form action="DoInsertst.jsp" method="post" name="zclist" onSubmit="return check(this)">
			<table>
				<tr>
					<td>学号：</td><td><input type="text" name="st_id" value=""></td>
				</tr>
				<tr>
					<td>姓名：</td><td><input type="text" name="st_name" value=""></td>
				</tr>
				<tr>
					<td>性别：</td><td><input type="radio" name="st_sex" value="男" checked>男
				           <input type="radio" name="st_sex" value="女">女</td>
				</tr>
				<tr>
					<td>所在班级：</td><td><input type="text" name="st_banji" value=""></td>
				</tr>
				<tr>
					<td>所在系：</td><td><input type="text" name="st_xi" value=""></td>
				</tr>
				<tr><td>学年：</td> <td>
					<select name="xuenian">
						<option value="大一">大一</option>
						<option value="大二">大二</option>
						<option value="大三">大三</option>
						<option value="大四">大四</option>
					</select></td></tr>
				<tr><td>学期：</td> <td>
					<select name="xueqi">
						<option value="第一学期">第一学期</option>
						<option value="第二学期">第二学期</option>
					</select></td></tr>
				<tr>
					<td><input type="submit" value="提交"></td>
			           <td><input type="reset" value="重置"></td>
			    </tr>
            </table>
		 </form>
	</div>
</body>
</html>