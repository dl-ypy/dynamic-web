package com.ypy.mystruts.model;

import java.util.HashMap;
import java.util.Map;

public class ActionModel {
	private String name;
	private String classes;
	private String method;
	private Map<String, ResultModel> resultMap = new HashMap<String, ResultModel>();
	public ActionModel(String name, String classes, String method, Map<String, ResultModel> resultMap) {
		super();
		this.name = name;
		this.classes = classes;
		this.method = method;
		this.resultMap = resultMap;
	}
	public ActionModel() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, ResultModel> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, ResultModel> resultMap) {
		this.resultMap = resultMap;
	}
	@Override
	public String toString() {
		return "ActionModel [name=" + name + ", classes=" + classes + ", method=" + method + ", resultMap=" + resultMap
				+ "]";
	}
}
