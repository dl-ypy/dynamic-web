var pb;
var max = 100;
var current = 0;

$(document).ready(function(){
	pb = $("#div");
	pb.progressbar({max:100})
	setInterval(changepb,100);//ÿ100����ˢ��
});

function changepb(){
	current++;
	if (current >= 100){//�������100ʱ���¿�ʼ
		current = 0;
	}
	pb.progressbar("option","value",current);
}