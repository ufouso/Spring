package com.xpp.test.service;

import java.util.List;

import com.xpp.test.exception.TestOneException;
import com.xpp.test.ioEntity.Student;


public interface StudentService {
	
	/**
	 * 根据Id查询学生
	 * @param id
	 * @return
	 */
	public Student findByStuId(String id);
	/**
	 * 添加学生
	 * @param s
	 */
	public void addStudent(Student s);
	/**
	 * 修改学生
	 * @param s
	 */
	public void updateStudent(Student s) throws ClassNotFoundException ;
	
	public void deleteStudent(String id) throws TestOneException;
	
	public List<Student> getList();
}
