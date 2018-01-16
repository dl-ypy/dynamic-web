$(document).ready(function(){
	$("#btn1").click(function(){
		$("#div").remove();//删除全部的元素
	});
	$("#btn2").click(function(){
		$("#div").empty();//删除里面的元素
	});
});