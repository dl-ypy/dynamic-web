$(document).ready(function(){
	$("#btn").on("click",clickHand1);//���¼�
	$("#btn").on("click",clickHand2);
	$("#btn").off("click",clickHand1);//����¼�һ�İ�
	
	$("body").on("click",bodyHandler);
	$("div").on("click",divHandler);
	
	$("#btnid").click(function(){
		var e = jQuery.Event("�Զ����¼�");
		$("#btnid").trigger(e);
	});
	$("#btnid").on("�Զ����¼�",ziDinYi);
});

//���¼��ĺ���
function clickHand1(e)
{
	console.log("�¼�һ������");
}

function clickHand2(e)
{
	console.log("�¼���������");
	event.stopPropagation();
}

//�¼�ð�ݵĺ���
function bodyHandler(event)
{
	console.log(event);//����̨����ʾ���¼������У�currentTarget:body��ʾ��body�������¼�����  target:div��ʾ�������div
}

function divHandler(event)
{
	console.log(event);
	event.stopPropagation();//��ֹ�¼�ð�ݾ���ֹ�����¼���ֻʣ��div��
	//event.stopImmediatePropagation;  ������ֹ����ֹ����������
}

//�Զ����¼��ĺ���
function ziDinYi(event){
		console.log(event);
		//event.stopPropagation();    �����ֹð��Ϊʲô��ֹ���ˣ�������������������������������������������
}