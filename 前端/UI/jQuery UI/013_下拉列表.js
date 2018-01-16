$(function(){
	var a = $("#input");
	a.spinner();//点击可以改变文本框中的数字
	a.spinner("value","100");//设置默认值
	$("#btn").on("click",function(){//得到文本框中的值
		alert(a.spinner("value"));
	});
	
	$("#tabs").tabs();
})