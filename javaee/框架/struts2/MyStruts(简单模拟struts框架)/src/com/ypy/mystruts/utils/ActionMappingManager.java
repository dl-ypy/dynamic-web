package com.ypy.mystruts.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ypy.mystruts.model.ActionModel;
import com.ypy.mystruts.model.ResultModel;

public class ActionMappingManager {
	private Map<String, ActionModel> actionMap = new HashMap<String, ActionModel>();
	
	public void init() {
		//获取SAXReader实例
		SAXReader reader = new SAXReader();
		//获取文件
		URL url = ActionMappingManager.class.getResource("/struts.xml");
		File file = new File(url.getPath());
		//获取document文档对象
		try {
			Document document = reader.read(file);
			//获取根节点
			Element root = document.getRootElement();
			//获取子节点
			List<Element> actionNodes = root.elements();
			//遍历action节点
			for (Element actionEle : actionNodes) {
				String actionName = actionEle.attributeValue("name");
				String classes = actionEle.attributeValue("class");
				String method = actionEle.attributeValue("method");
				List<Element> resultNodes = actionEle.elements();
				Map<String, ResultModel> resultMap = new HashMap<String, ResultModel>();
				//遍历result节点
				for (Element resultEle : resultNodes) {
					String resultName = resultEle.attributeValue("name");
					String type = resultEle.attributeValue("type");
					String path = resultEle.getText();
					ResultModel result = new ResultModel(resultName, type, path);
					resultMap.put(resultName, result);       //将reslut节点存入Map
				}
				ActionModel action = new ActionModel(actionName, classes, method, resultMap);
				actionMap.put(actionName, action);     //将action节点存入Map
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	//根据key值返回一个所匹配的actionmodel
	public ActionModel getActionModel(String name) {
		return actionMap.get(name);
	}
}
