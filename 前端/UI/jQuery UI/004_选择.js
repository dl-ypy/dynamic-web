$(document).ready(function(){
	$("#btn").button();//设置为按钮的样式
	$("#select").selectable();//选择
	$("#btn").on("click",function(){
		if ($("#right").hasClass("ui-selected"))//判断是否为正确答案
		{
			alert("恭喜你答对了！");
		}
		else
		{
			alert("答案错误！");
		}
	});
});