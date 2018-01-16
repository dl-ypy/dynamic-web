/**
 * 封装IE和Firefox类浏览器中装载同域XML文件或XML字符串的方法，返回的是XML文档对应的DOM对象中的根元素节点
 * @param flag true表示装载的是XML的文件，false表示装载的是XML的字符串
 * @param xmldoc flag为true表示XML文件的路径，flag为false表示XML字符串
 * @return 根元素节点
 */
function loadXML(flag, xmldoc) {
	if (!!window.ActiveXObject || "ActiveXObject" in window) {
		//IE浏览器
		var activexName = ["MSXML2.DOMDocument","Miscrosoft.XmlDom"];//尝试创建    IE10创建不成功
		var xmlObj;
		for (var i=0; i<activexName.length; i++) {
			try {
				xmlObj = new ActiveXObject(activeName[i]);
				break;
			} catch(e) {
				
			}
		}
		if (xmlObj) {
			//创建成功
			//同步方式装载XML数据
			xmlObj.async = false;
			if (flag) {
				//装载XML文件
				xmlObj.load(xmldoc);
			} else {
				//装载XML字符串
				xmlObj.loadXML(xmldoc);
			}
			return xmlObj.documentElement;
		} else {
			alert("装载XML文档的对象创建失败！");
			return null;
		}
	} else if(document.implementation.createDocument) {
		//Firefox类浏览器
		var xmlObj;
		if (flag) {
			//装载XML文件
			xmlObj = document.implementation.createDocument("", "", null);
			if (xmlObj) {
				//同步方式装载
				xmlObj.async = false;
				xmlObj.load(xmldoc);
				return xmlObj.documentElement;
			} else {
				alert("装载XML文档的对象创建失败！");
				return null;				
			}
		} else {
			//装载XML字符串
			xmlObj = new DOMParser();
			var docRoot = xmlObj.parseFromString(xmldoc, "text/xml");
			return docRoot.documentElement;
		}
	}
	alert("装载XML文档的对象创建失败！");
	return null;
}
























