var valueSpan,slider;

$(document).ready(function(){
	slider = $("#slider");
	valueSpan = $("#span");
	
	slider.slider({//ʹ���϶�������ʱ��ֵ��仯
		slide:function(event, ui){
			valueSpan.text(slider.slider("option","value"));
		}
	});
});