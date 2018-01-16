$(document).ready(function(){
	$(".main>a").hover(function(){//.main>a表示只有鼠标滑过主菜单时才反应
		var ulNode = $(this).next("ul");//指向当前的ul
//		if (ulNode.css("display") == "none")//判断当前ul是否隐藏
//		{
//			ulNode.css("display","block");
//		}else
//		{
//			ulNode.css("display","none");
//		}
		//ulNode.toggle(500);//jQuery简化
		ulNode.slideToggle(500);
	});
});