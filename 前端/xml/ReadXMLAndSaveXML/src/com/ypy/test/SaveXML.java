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
		//通用的步骤
		//1、通过DocumentHelper  创建一个Document对象
		Document doc = DocumentHelper.createDocument();
		//2、通过DocumentHelper创建一个根节点
		Element root = DocumentHelper.createElement("students");
		//3、将根节点添加到doc中
		doc.setRootElement(root);
		
		//根据用户需求创建不同的子节点
		//4、给根节点添加不同的子节点
		Element ele =  root.addElement("student");
		//5、对添加的子节点设置属性
		ele.addAttribute("sid", "1");//返回一个sid  element   可以不接受
		//6、给student添加子节点
		Element sname = ele.addElement("sname");
		sname.setText("李四");
		
		Element sage = ele.addElement("sage");
		sage.setText("22");
		
		Element ssex = ele.addElement("ssex");
		ssex.setText("男");
		
		//7、将对应的Document对象写入到xml文件中
		File file = new File("xml/NewStudents.xml");
		FileOutputStream out = null;
		XMLWriter writer = null;
		try {
			
			out = new FileOutputStream(file);
			//第一个参数表示写入一行数据时是否缩进，第二个数据表示写入一行数据时是否换行，true表示换行，false表示不换行
			OutputFormat format = new OutputFormat("\t", true);
			
			
			writer = new XMLWriter(out,format);
			//将Document的内容写入到文件中
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
