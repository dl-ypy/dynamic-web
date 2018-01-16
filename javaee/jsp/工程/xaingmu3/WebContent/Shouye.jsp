<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>首页</title>
	<style>
                        #id0{
				width:1002px;
				margin:0px auto;
			}

			#id0 #head img{	
				height:150px;
			        width:1002px;
			}

			#id0 #biaoti{
				width:1002px;
				height:30px;
				background:url(images/article_on_bg.gif);
			}

			#id0 #biaoti li{
				list-style:none;
				float:left;
				margin:10px;
				width:90px;
				text-align:center;
				line-height:10px;
			}

			#id0 #left{
				width:700px;
				height:600px;
				background:#EDEDED;
				float:left;
			}

		        #id0 #left .four{
				width:300px;
				height:280px;
				float:left;
				margin-right:40px;
			}

			#id0 #left .four .redian{
				width:300px;
				height:30px;
				float:left;
				background:url(images/a.png);
			}

			#id0 #left .four .redian font{
				text-size:60px;
				line-height:10px;
				display:block;
				margin:10px;
			}

			#id0 #left .four .redian .xinwen li{
				line-height:30px;
			}

			#id0 #right{
				width:300px;
				height:600px;
				background:#EDEDED;
				float:right;
			}

			#id0 #right #denglu{
				margin-left:30px;
				margin-top:10px;
			}

			#id0 #right #denglu a{
				text-decoration:none;
			}

			a:link{
				color:blue;
			}
			a:hover{
				color:red;
			}

			#id0 #right #tupian #biaoti{
				width:300px;
				margin-top:10px;
				background:url(images/article_on_bg.gif);
			}

			#id0 #right #tupian #tupian1{
				margin-top:10px;
				margin-left:30px;
			}

			#id0 #dibu{
				width:1002px;
				height:30px;
				background:url(images/article_on_bg.gif);
				margin:0px auto;
			}

			#main{
				width:1002px;
				height:600px;
			}
			
			
                </style>

		<script language="javascript">
                	function check(DL)
			{
				var yonghu = DL.username.value;
				var mima = DL.password.value;
				if(yonghu == "")
				{
					alert("用户名为空！");
					DL.yonghu.focus();
					DL.yonghu.select();
					return false;
				}
				if(mima == "")
				{
					alert("密码为空！");
					DL.mima.focus();
					DL.mima.select();
					return false;
				}
			}
		</script>
</head>
<body>
	<div id="id0">
	        	<div id="head">
				<img src="images/1.jpg"></img>
			</div>

			<div id="biaoti">
			        <ul>
					<li>学校概述</li>
					<li>学院设置</li>
					<li>教学工作</li>
					<li>师资力量</li>
					<li>校园文化</li>
					<li>国际交流</li>
				</ul>
			</div>
			
			<div id="main"><!--和底部分开-->
			<div id="left">
				<div class="four"><!--用来调整4快新闻区域的分布-->
					<div class="redian"><!--用来组合图片和标题-->
						<font>校园公告</font>
						<div class="xinwen">
							<ul>
								<li>交学费通知</li>
								<li>停电通知</li>
								<li>停水通知</li>
								<li>讲座通知</li>
								<li>断网通知</li>
								<li>放假时间通知</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="four"><!--用来调整4快新闻区域的分布-->
					<div class="redian"><!--用来组合图片和标题-->
						<font>教学进展</font>
						<div class="xinwen">
							<ul>
								<li>本年度教学目标</li>
								<li>大一教学计划</li>
								<li>大二教学计划</li>
								<li>大三教学计划</li>
								<li>大四教学计划</li>
								<li>各种考试安排</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="four"><!--用来调整4快新闻区域的分布-->
					<div class="redian"><!--用来组合图片和标题-->
						<font>传统文化</font>
						<div class="xinwen">
							<ul>
								<li>学校发展</li>
								<li>英雄楷模</li>
								<li>学校校徽详解</li>
								<li>校歌由来</li>
								<li>中北精神</li>
								<li>如何坚持发扬中北传统文化</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="four"><!--用来调整4快新闻区域的分布-->
					<div class="redian"><!--用来组合图片和标题-->
						<font>趣味新闻</font>
						<div class="xinwen">
							<ul>
								<li>戏说二龙山</li>
								<li>篮球的故事</li>
								<li>欢乐学习</li>
								<li>中北雾霾多</li>
								<li>中北人的素质</li>
								<li>形式主义</li>
							</ul>
						</div>
					</div>
				</div>

			</div>

			<div id="right">
				<div id="denglu">
					<form name="DL" action="ServletUser" method="post" target="_blank" onSubmit="return check(this)"><!--***********************************-->
									<%--此处链接到servlst路径 --%>
						<table>
							<tr><td>用户名：</td> <td><input type="text" name="username" value=""/></td></tr>
							<tr><td>密码：</td> <td><input type="password" name="password" value=""/></td></tr>
							<tr><td>用户身份：</td> <td>
									<select name="type">
										<option value="普通用户">普通用户</option>
										<option value="管理员">管理员</option>
									</select></td></tr>
							<tr><td><input type="submit" value="登陆"></td> <td><input type="reset" value="重置"><a href="Zhuce.jsp" target="_blank">&nbsp;&nbsp;&nbsp;&nbsp;注册</a></td></tr>
						</table>
					</form>
				</div>

				<div id="tupian">
					<div id="biaoti">精彩中北</div><!--必须是div-->
					<div id="tupian1">
						<img src="images/2.jpg"></img>
					</div>
					<div id="tupian1">
						<img src="images/3.jpg"></img>
					</div>
				</div>
			</div>
			</div>

			<hr color="blue">
			<div id="dibu">
				<p align="center">中北大学软件学院开发<br></p>
			</div>
		
				
		</div>
	
</body>
</html>