var a = $.noConflict();//Ïû³ıÃÀÔª·ûºÅ
a(document).ready(function(){
	a("#btn").on("click",function(){
		a("div").text("new Hello");
	});
});