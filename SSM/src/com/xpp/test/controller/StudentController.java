package com.xpp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xpp.test.exception.TestOneException;
import com.xpp.test.ioEntity.Student;
import com.xpp.test.service.StudentService;
import com.xpp.test.utils.LogUtil;

@RequestMapping("/student")
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/findOne.do")
	@ResponseBody
	public Student findOne(@RequestBody Student s){
		LogUtil.info(s.toString());
		return studentService.findByStuId(s.getId());
	}
	
	@RequestMapping("/addOne.do")
	@ResponseBody
	public void addOne(@RequestBody Student s){
		LogUtil.info(s.toString());
		studentService.addStudent(s);
	}
	
	
	@RequestMapping("/updateOne.do")
	@ResponseBody
	public void updateOne(@RequestBody Student s) throws ClassNotFoundException{
		LogUtil.info(s.toString());
		studentService.updateStudent(s);
	}
	
	@RequestMapping("/deleteOne.do")
	@ResponseBody
	public void deleteOne(String id) throws TestOneException{
		LogUtil.info(id);
		studentService.deleteStudent(id);
	}
	
	@RequestMapping("/findAll.do")
	@ResponseBody
	public List<Student> getSomeList(){
		return studentService.getList();
	}
	
	
//TODO 以下方法会报错，需要解决。	
//	@RequestMapping(value="/test1.do", method=RequestMethod.GET)
//	@ResponseBody
//	public String test1(){
//		return "get";
//	}
//	
//	@RequestMapping(value="/test2.do",method=RequestMethod.POST)
//	@ResponseBody
//	public String test2(){
//		return "post";
//	}
	
}
