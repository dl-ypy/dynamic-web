$(document).ready(function(){
	$("#div2").draggable();//能拖动
	$("#div1").droppable();//允许放置
	
	$("#div1").on("drop", function(event, ui){
		$("#div1").text("放置后触发的drop事件");
	});
});