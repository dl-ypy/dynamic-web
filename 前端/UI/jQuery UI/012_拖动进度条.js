var valueSpan,slider;

$(document).ready(function(){
	slider = $("#slider");
	valueSpan = $("#span");
	
	slider.slider({//使得拖动进度条时数值会变化
		slide:function(event, ui){
			valueSpan.text(slider.slider("option","value"));
		}
	});
});