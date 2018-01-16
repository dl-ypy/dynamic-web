$(document).ready(function(){
	$("#btn1").click(function(){
		$("#pid1").append("在后面添加成功");
	});
	$("#btn2").click(function(){
		$("#pid2").prepend("在前面添加成功");
	});
	$("#btn3").click(function(){
		$("#pid3").after("在后面换行添加成功");
	});
	$("#btn4").click(function(){
		$("#pid4").before("在前面换行添加成功");
	});
});

function appendText()
{
	var text1 = "<p>aaaaaa</p>"//通过html添加
	var text2 = $("<a href='#'></a>").text("bbbbbbb");//通过jQuery添加
	var text3 = document.createElement("p");//通过DOM添加
	text3.innerHTML = "ccccccc";
	$("body").append(text1,text2,text3);//添加到body中
}