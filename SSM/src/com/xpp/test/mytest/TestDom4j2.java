package com.xpp.test.mytest;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 测试dom4j,构建Document对象
 * @Description 
 * @author xpp
 * @date 2017年9月6日 下午6:33:40
 */
public class TestDom4j2 {
	
	public void start(){
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("project");
		Element path = root.addElement("path");
		path.addAttribute("name", "faker");
		path.addText("你想说什么？");
		
		//写出
		XMLWriter write = new XMLWriter();
		FileOutputStream os;
		try {
			os = new FileOutputStream(new File("E:\\workspace8\\SSM\\src\\com\\xpp\\test\\mytest\\NO2.xml"));
			write.setOutputStream(os);
			write.write(doc);
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestDom4j2 td2 = new TestDom4j2();
		td2.start();
	}
}
