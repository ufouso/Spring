package com.xpp.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xpp.test.ioEntity.Student;

public interface StudentDao {
	
	public Student findById(String id);
	
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public void deleteStudent(String id);
	
	@Select("select * from student")
	public List<Student> findSome();
}
