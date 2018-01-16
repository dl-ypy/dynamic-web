/**
 * 根据指定的xpat表达式查找满足条件的第一个节点
 * @param xmldoc 执行查找的节点
 * @param sXpath xpath的表达式
 */
function selectSingleNode(xmldoc, sXpath) {
	if (!!window.ActiveXObject || "ActiveXObject" in window) { 
		//IE浏览器
		return xmldoc.selectSingleNode(sXpath);
	} else if(window.XPathEvaluator) {
		//Firefox类浏览器
		var xpathObj = new XPathEvaluator();
		if (xpathObj) {
			var result = xpathObj.evaluate(sXpath,xmldoc,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null);
			return result.singleNodeValue;
		} else {
			return null;
		}
	} else {
		return null;
	}
}


/**
 * 根据指定的xpath表达式查找满足条件的所有节点
 * @param xmldoc 执行查找的节点
 * @param sXpath xpath的表达式
 */
function selectNodes(xmldoc, sXpath) {
	if (!!window.ActiveXObject || "ActiveXObject" in window) { 
		//IE浏览器
		return xmldoc.selectSingleNode(sXpath);
	} else if(window.XPathEvaluator) {
		//Firefox类浏览器
		var xpathObj = new XPathEvaluator();
		if (xpathObj) {
			var result = xpathObj.evaluate(sXpath,xmldoc,null,XPathResult.ORDERED_NODE_ITERATOR_TYPE,null);
			var nodes = new Array();
			var node;
			while ((node=result.iterateNext()) != null) {
				nodes.push(node);
			}
			return nodes;
		} else {
			return null;
		}
	} else {
		return null;
	}

}





