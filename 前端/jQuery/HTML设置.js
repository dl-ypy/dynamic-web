$(document).ready(function(){
	$("#btn1").click(function(){
		$("#p1").text("���ݱ�������");
	});
	$("#btn2").click(function(){
		$("#p2").html("<a href='#'>��Ϊ��������</a>");
	});
	$("#btn3").click(function(){
		$("#it").val("�ı������ݱ�������");
	});
	$("#btn4").click(function(){//�޸�a��ǩ��href����   ���޸Ķ������
		$("#aid").attr({
			"href":"http://www.qq.com",
			"title":"hello"
		});
	});
	$("#btn5").click(function(){
		$("#p3").text(function(i,ot){//�ص��ķ�ʽ������html,val,attr�ȷ�������
			return "ԭ�������ݣ�"+ot+"�µ����ݣ�"+(i);
		});
	})
});