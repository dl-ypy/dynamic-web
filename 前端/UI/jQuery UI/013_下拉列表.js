$(function(){
	var a = $("#input");
	a.spinner();//������Ըı��ı����е�����
	a.spinner("value","100");//����Ĭ��ֵ
	$("#btn").on("click",function(){//�õ��ı����е�ֵ
		alert(a.spinner("value"));
	});
	
	$("#tabs").tabs();
})