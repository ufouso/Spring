package com.xpp.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ignoreUnknownFields=false告诉Spring Boot在有属性不能匹配到声明的域的时候抛出异常。
 * @author xpp
 *
 */
@ConfigurationProperties(prefix="xpp")
@Component
public class MyConfigureOne {
	
	private String name;
	
	private String age;
	
	private String sex;
	
//	private Picture p;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

//	public Picture getP() {
//		return p;
//	}
//
//	public void setP(Picture p) {
//		this.p = p;
//	}
//
//	@Override
//	public String toString() {
//		return "MyConfigureOne [name=" + name + ", age=" + age + ", sex=" + sex + ", p=" + p + "]";
//	}
	
}
