var pb;
var max = 100;
var current = 0;

$(document).ready(function(){
	pb = $("#div");
	pb.progressbar({max:100})
	setInterval(changepb,100);//每100毫秒刷新
});

function changepb(){
	current++;
	if (current >= 100){//如果等于100时重新开始
		current = 0;
	}
	pb.progressbar("option","value",current);
}