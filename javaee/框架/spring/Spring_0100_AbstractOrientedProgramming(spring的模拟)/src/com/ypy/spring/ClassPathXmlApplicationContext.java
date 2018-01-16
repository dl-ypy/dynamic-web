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
		Document doc = sb.build(this.getClass().getResourceAsStream("beans.xml"));//�����ĵ�����
		//System.out.println(this.getClass().getClassLoader());
		Element root = doc.getRootElement();//��ȡ��Ԫ��
		List list = root.getChildren("bean");//��ȡbeanԪ��
		for (int i=0; i<list.size(); i++) {
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id + ":" + clazz);
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);
			
											//��ȡbeanԪ�������propertyԪ��
			for (Element propertyElement : (List<Element>)element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name");//�õ�userdao
				String bean = propertyElement.getAttributeValue("bean");//�õ�u
				Object beanObject = beans.get(bean);//�õ�UserDaoImpl�Ķ���
				
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);//ƴ�ӷ�����
				System.out.println("method name = " + methodName);
				
				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);//��������ƴ�Ӻõķ���
				
				System.out.println("o=" + o + ", beanObject" + beanObject);
				
				m.invoke(o,beanObject);//ִ�и÷���
		
			}
		}
		
	}
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
