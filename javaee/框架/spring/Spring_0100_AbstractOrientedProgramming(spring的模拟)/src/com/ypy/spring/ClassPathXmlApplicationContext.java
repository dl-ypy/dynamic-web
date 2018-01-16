package com.ypy.spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.ypy.dao.impl.UserDaoImpl;

public class ClassPathXmlApplicationContext implements BeanFactory{
	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getResourceAsStream("beans.xml"));//创建文档对象
		//System.out.println(this.getClass().getClassLoader());
		Element root = doc.getRootElement();//获取根元素
		List list = root.getChildren("bean");//获取bean元素
		for (int i=0; i<list.size(); i++) {
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id + ":" + clazz);
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
											//获取bean元素下面的property元素
			for (Element propertyElement : (List<Element>)element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name");//得到userdao
				String bean = propertyElement.getAttributeValue("bean");//得到u
				Object beanObject = beans.get(bean);//得到UserDaoImpl的对象
				
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);//拼接方法名
				System.out.println("method name = " + methodName);
				
				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);//调用上述拼接好的方法
				
				System.out.println("o=" + o + ", beanObject" + beanObject);
				
				m.invoke(o,beanObject);//执行该方法
		
			}
		}
		
	}
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
