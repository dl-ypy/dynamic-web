$(document).ready(function(){
	$(".main>a").hover(function(){//.main>a��ʾֻ����껬�����˵�ʱ�ŷ�Ӧ
		var ulNode = $(this).next("ul");//ָ��ǰ��ul
//		if (ulNode.css("display") == "none")//�жϵ�ǰul�Ƿ�����
//		{
//			ulNode.css("display","block");
//		}else
//		{
//			ulNode.css("display","none");
//		}
		//ulNode.toggle(500);//jQuery��
		ulNode.slideToggle(500);
	});
});