<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
	<style>
		#dh{
			position:absolute;
			top:1px;
			left:350px;
		    width:700px;
			height:260px;
			background:url(images/4.jpg);
		}
		#zj{
		    width:1366px;
			height:468px;
		}
		#zj img{
		float:left;
		}
		#zuo img{
			float:left;
			position:absolute;
			top:271px;
		    width:200px;
			height:468px;
			
		}
		#you img{
			position:absolute;
			top:271px;
			left:200px;
			float:right;
		    width:1166px;
			height:468px;
		}
		#mw{
			position:absolute;
			top:740px;
			left:0px;
		    width:1366px;
			height:40px;
			background:url(images/2.jpg);
		}
		.dz{
			margin-top:200px;
			margin-left:650px;
		
		}
	</style>
</head>
<body>
		<div id="sy">
			<div id="dh">					
			
			    <div class="dz">
			    <form action="dlxs.jsp" method="post">
			    	<input type="submit" value="学生登录">
	            </form>
	            <form action="dljs.jsp" method="post">
	            	<input type="submit" value="教师登录">
	            </form>
	            </div>
			</div>
			<div id="zj">
					<div id="zuo">
					<img src="images/9.jpg">
							</div>
					
					<div id="you">
						<img src="images/8.jpg">
					</div>
			</div>
				
			<div id="mw"><br/><center>版权所有：温志浩&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：学院路35号中北大学</center>
			</div>
		</div>
</body>
</html>