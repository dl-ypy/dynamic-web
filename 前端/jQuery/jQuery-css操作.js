$(document).ready(function(){
	$("#div1").css({
		width:"100px",height:"100px",backgroundColor:"#00FF00"
	});
	
	$("#div2").addClass("style1");
	$("#div2").click(function(){
		//$(this).removeClass("style1");//点击后移除
		$(this).toggleClass("style2");//点击不停地换颜色
	});
});