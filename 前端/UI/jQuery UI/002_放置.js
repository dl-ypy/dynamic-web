$(document).ready(function(){
	$("#div2").draggable();//���϶�
	$("#div1").droppable();//�������
	
	$("#div1").on("drop", function(event, ui){
		$("#div1").text("���ú󴥷���drop�¼�");
	});
});