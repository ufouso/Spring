package com.xpp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.ioEntity.Student;
import com.xpp.test.service.StudentService;
import com.xpp.test.utils.LogUtil;

@RequestMapping("/student")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/findOne",method=RequestMethod.POST)
	public Student findOne(String id){
		LogUtil.info(id);
		return studentService.findByStuId(id);
	}
	
	@RequestMapping("/addOne")
	public void addOne(@RequestBody Student s){
		LogUtil.info(s.toString());
		studentService.addStudent(s);
	}
	
	
	@RequestMapping("/updateOne")
	public void updateOne(@RequestBody Student s) throws ClassNotFoundException{
		LogUtil.info(s.toString());
		studentService.updateStudent(s);
	}
	
	@RequestMapping("/deleteOne")
	public void deleteOne(String id){
		LogUtil.info(id);
		studentService.deleteStudent(id);
	}
	
	@RequestMapping("/findAll")
	public List<Student> getSomeList(){
		return studentService.getList();
	}
	
}
