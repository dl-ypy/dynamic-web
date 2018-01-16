$(document).ready(function(){
	$("#btn1").click(function(){
		$("#p1").text("内容被更改了");
	});
	$("#btn2").click(function(){
		$("#p2").html("<a href='#'>改为超链接了</a>");
	});
	$("#btn3").click(function(){
		$("#it").val("文本框内容被更改了");
	});
	$("#btn4").click(function(){//修改a标签的href属性   能修改多个属性
		$("#aid").attr({
			"href":"http://www.qq.com",
			"title":"hello"
		});
	});
	$("#btn5").click(function(){
		$("#p3").text(function(i,ot){//回掉的方式，其他html,val,attr等方法类似
			return "原来的内容："+ot+"新的内容："+(i);
		});
	})
});