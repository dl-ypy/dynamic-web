$(document).ready(function(){//文档加载完后触发函数
	alert("文档加载完毕");
	$("p").click(function(){//点击哪个p标签就隐藏哪个
		$(this).hide();
	})
});