$(document).ready(function(){
	//���±���
	$("#div1").children().css({border:"3px solid red"});//childrenֻ���±���һ��
	$("#div1").find("a").css({border:"3px solid blue"});//find�������ºö༶
	
	//���ϱ���
	$("#a2").parent().css({border:"3px solid red"});//����һ��
	$("#p2").parents().css({border:"3px solid black"});//���϶༶
	$("#p2").parentsUntil("#div3").css({border:"3px solid yellow"});//��p��div3֮��ֻ��div4,����ֻ��div4�仯
	
	//ͬ������
	$("h3").siblings().css({border:"3px solid red"});//h3��ͬ������Ϊ��ɫ������h3
	$("h3").next().css({border:"3px solid yellow"});//h3����һ����Ϊ��ɫ
	$("h3").nextAll().css({border:"3px solid blue"});//h3����Ķ���Ϊ��ɫ
	$("h3").nextUntil("h5").css({border:"3px solid black"});//h3-h5֮��ı�Ϊ��ɫ
	/*
	prev()
	preAll()
	preUntil()
	��next(),nextAll(),nextUntil()�෴��Ϊ���ϵ�����
	*/
	
	//����
	$("#div6 p").first().css("background-color","yellow");//��һ��
	$("#div6 p").last().css("background-color","blue");//���һ��
	$("#div6 p").eq(1).css("background-color","pink");//����Ϊid������ 1��ʾ�ڶ���
	$("#div6 p").filter("p").css({border:"3px solid red"});//����������
	$("#div6 a").not(".pclass").css("background-color","aqua");//������������
});