package com.xpp.test.ioEntity;

import java.io.Serializable;

/**
 * 学生类
 * @author xpp
 */
public class Student implements Serializable{

	private static final long serialVersionUID = -7591259817985981208L;
	
	private String id;
	
	private String name;
	
	private String age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
