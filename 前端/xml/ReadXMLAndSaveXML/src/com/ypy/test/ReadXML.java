package com.ypy.test;
/**
 * 读取xml文件中的内容
 */
import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {
	public static void main(String[] args) throws DocumentException {
		//1、获取SAXReader实例
		SAXReader reader = new SAXReader();
		//2、获取项目了文件
		URL url = ReadXML.class.getClassLoader().getResource("xml/students.xml");
		File file = new File(url.getPath());
		//3、根据xml文件获取对应的document文档对象
		Document document = reader.read(file);
		//4、通过doc的对象获取xml文件中的根节点
		Element ele = document.getRootElement();
		//5、获得根节点下面的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> nodes = ele.elements();
		//遍历节点
		for (Element element : nodes) {
			String sid = element.attributeValue("id");
			String sname = element.elementTextTrim("name");
			String sage = element.elementTextTrim("age");
			System.out.println(sid+","+sname+","+sage);
		}
	}
}
/*
 ***************jdk1.8运行结果***************
1,张三1,12
2,张三2,12
3,张三3,12
 */
