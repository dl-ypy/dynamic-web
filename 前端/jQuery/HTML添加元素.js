$(document).ready(function(){
	$("#btn1").click(function(){
		$("#pid1").append("�ں�����ӳɹ�");
	});
	$("#btn2").click(function(){
		$("#pid2").prepend("��ǰ����ӳɹ�");
	});
	$("#btn3").click(function(){
		$("#pid3").after("�ں��滻����ӳɹ�");
	});
	$("#btn4").click(function(){
		$("#pid4").before("��ǰ�滻����ӳɹ�");
	});
});

function appendText()
{
	var text1 = "<p>aaaaaa</p>"//ͨ��html���
	var text2 = $("<a href='#'></a>").text("bbbbbbb");//ͨ��jQuery���
	var text3 = document.createElement("p");//ͨ��DOM���
	text3.innerHTML = "ccccccc";
	$("body").append(text1,text2,text3);//��ӵ�body��
}