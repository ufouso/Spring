package com.xpp.test.mytest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xpp.test.ioEntity.Student;
public class TestBeanXml {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
		Student s = ctx.getBean("student",Student.class);
		s.getName();
	}
}
