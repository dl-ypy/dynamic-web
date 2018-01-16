package com.ypy.test;
/**
 * ��ȡxml�ļ��е�����
 */
import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {
	public static void main(String[] args) throws DocumentException {
		//1����ȡSAXReaderʵ��
		SAXReader reader = new SAXReader();
		//2����ȡ��Ŀ���ļ�
		URL url = ReadXML.class.getClassLoader().getResource("xml/students.xml");
		File file = new File(url.getPath());
		//3������xml�ļ���ȡ��Ӧ��document�ĵ�����
		Document document = reader.read(file);
		//4��ͨ��doc�Ķ����ȡxml�ļ��еĸ��ڵ�
		Element ele = document.getRootElement();
		//5����ø��ڵ�����������ӽڵ�
		@SuppressWarnings("unchecked")
		List<Element> nodes = ele.elements();
		//�����ڵ�
		for (Element element : nodes) {
			String sid = element.attributeValue("id");
			String sname = element.elementTextTrim("name");
			String sage = element.elementTextTrim("age");
			System.out.println(sid+","+sname+","+sage);
		}
	}
}
/*
 ***************jdk1.8���н��***************
1,����1,12
2,����2,12
3,����3,12
 */
