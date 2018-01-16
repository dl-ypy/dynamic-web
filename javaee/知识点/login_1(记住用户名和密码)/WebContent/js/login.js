/*得到元素*/
function $(id) {
	return document.getElementById(id);
}

var select = false;
/*判断是否选择记住密码*/
function ruleRemberSelect() {
	if (select == false) {
		select = true;
	} else {
		select = false;
	}
	if (select) {
		$('rember').value = "selected";
	}
}
