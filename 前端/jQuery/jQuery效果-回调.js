$(document).ready(function(){
	$("#btn").click(function(){
		$("#pid").hide(1000,function(){
			alert("动画执行完毕，被回调");
		});
	});
});