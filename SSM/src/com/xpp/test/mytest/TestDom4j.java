package com.xpp.test.mytest;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 测试dom4j
 * @Description 
 * @author xpp
 * @date 2017年9月6日 下午3:47:10
 */
public class TestDom4j {

	public void testSome() throws Exception{
		//创建saxReader
		SAXReader s = new SAXReader();
		//读取指定文件
		Document doc = s.read(new File("E:\\workspace8\\SSM\\src\\com\\xpp\\test\\mytest\\NO1.xml"));
		//获取根元素
		Element element = doc.getRootElement();
		System.out.println(element);
		//获取当前元素的指定名称的子元素
		Element ee = element.element("collections");
		System.out.println(ee);
		
		//获取当前元素下的所有元素
		List<Element> ele1 = element.elements();
		for(Element e : ele1){
			System.out.println("获取节点的名称："+e.getName()+"----"+e.getText()+"-----获取当前元素的第2个属性"+e.attribute(1)+"---获取当前元素的faker属性"+e.attribute("faker"));
			List<Element> ele2 = e.elements();
			for(Element ee1 : ele2){
				System.out.println(ee1.getName());
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			TestDom4j j4 = new TestDom4j();
			j4.testSome();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
