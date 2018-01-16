$(document).ready(function(){
	//向下遍历
	$("#div1").children().css({border:"3px solid red"});//children只向下遍历一级
	$("#div1").find("a").css({border:"3px solid blue"});//find可以向下好多级
	
	//向上遍历
	$("#a2").parent().css({border:"3px solid red"});//向上一级
	$("#p2").parents().css({border:"3px solid black"});//向上多级
	$("#p2").parentsUntil("#div3").css({border:"3px solid yellow"});//从p到div3之间只有div4,所以只有div4变化
	
	//同级遍历
	$("h3").siblings().css({border:"3px solid red"});//h3的同级都变为红色，除了h3
	$("h3").next().css({border:"3px solid yellow"});//h3的下一个变为黄色
	$("h3").nextAll().css({border:"3px solid blue"});//h3后面的都变为蓝色
	$("h3").nextUntil("h5").css({border:"3px solid black"});//h3-h5之间的变为黑色
	/*
	prev()
	preAll()
	preUntil()
	与next(),nextAll(),nextUntil()相反，为向上的区间
	*/
	
	//过滤
	$("#div6 p").first().css("background-color","yellow");//第一个
	$("#div6 p").last().css("background-color","blue");//最后一个
	$("#div6 p").eq(1).css("background-color","pink");//参数为id的索引 1表示第二个
	$("#div6 p").filter("p").css({border:"3px solid red"});//满足条件的
	$("#div6 a").not(".pclass").css("background-color","aqua");//不满足条件的
});