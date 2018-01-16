$(document).ready(function(){
	$("#btn").on("click",clickHand1);//绑定事件
	$("#btn").on("click",clickHand2);
	$("#btn").off("click",clickHand1);//解除事件一的绑定
	
	$("body").on("click",bodyHandler);
	$("div").on("click",divHandler);
	
	$("#btnid").click(function(){
		var e = jQuery.Event("自定义事件");
		$("#btnid").trigger(e);
	});
	$("#btnid").on("自定义事件",ziDinYi);
});

//绑定事件的函数
function clickHand1(e)
{
	console.log("事件一被绑定了");
}

function clickHand2(e)
{
	console.log("事件二被绑定了");
	event.stopPropagation();
}

//事件冒泡的函数
function bodyHandler(event)
{
	console.log(event);//控制台中显示了事件，其中：currentTarget:body表示对body进行了事件监听  target:div表示点击的是div
}

function divHandler(event)
{
	console.log(event);
	event.stopPropagation();//阻止事件冒泡就阻止父级事件，只剩下div的
	//event.stopImmediatePropagation;  这种阻止是阻止后续的所有
}

//自定义事件的函数
function ziDinYi(event){
		console.log(event);
		//event.stopPropagation();    这个阻止冒泡为什么阻止不了？？？？？？？？？？？？？？？？？？？？？？
}