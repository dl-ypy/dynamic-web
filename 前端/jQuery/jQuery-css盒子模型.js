$(document).ready(function(){
	alert("当前元素的高度："+$("#div").height());
	alert("当前元素加内边距的高度："+$("#div").innerHeight());
	alert("当前元素加内边距加边框的高度："+$("#div").outerHeight());//无参数
	alert("当前元素加内边距加边框加外边距的高度："+$("#div").outerHeight(true));//有参数
});