$(document).ready(function(){
	$("#btn").button();//����Ϊ��ť����ʽ
	$("#select").selectable();//ѡ��
	$("#btn").on("click",function(){
		if ($("#right").hasClass("ui-selected"))//�ж��Ƿ�Ϊ��ȷ��
		{
			alert("��ϲ�����ˣ�");
		}
		else
		{
			alert("�𰸴���");
		}
	});
});