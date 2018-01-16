package com.ypy.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class SaveXML {
	public static void main(String[] args) {
		//ͨ�õĲ���
		//1��ͨ��DocumentHelper  ����һ��Document����
		Document doc = DocumentHelper.createDocument();
		//2��ͨ��DocumentHelper����һ�����ڵ�
		Element root = DocumentHelper.createElement("students");
		//3�������ڵ���ӵ�doc��
		doc.setRootElement(root);
		
		//�����û����󴴽���ͬ���ӽڵ�
		//4�������ڵ���Ӳ�ͬ���ӽڵ�
		Element ele =  root.addElement("student");
		//5������ӵ��ӽڵ���������
		ele.addAttribute("sid", "1");//����һ��sid  element   ���Բ�����
		//6����student����ӽڵ�
		Element sname = ele.addElement("sname");
		sname.setText("����");
		
		Element sage = ele.addElement("sage");
		sage.setText("22");
		
		Element ssex = ele.addElement("ssex");
		ssex.setText("��");
		
		//7������Ӧ��Document����д�뵽xml�ļ���
		File file = new File("xml/NewStudents.xml");
		FileOutputStream out = null;
		XMLWriter writer = null;
		try {
			
			out = new FileOutputStream(file);
			//��һ��������ʾд��һ������ʱ�Ƿ��������ڶ������ݱ�ʾд��һ������ʱ�Ƿ��У�true��ʾ���У�false��ʾ������
			OutputFormat format = new OutputFormat("\t", true);
			
			
			writer = new XMLWriter(out,format);
			//��Document������д�뵽�ļ���
			writer.write(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
