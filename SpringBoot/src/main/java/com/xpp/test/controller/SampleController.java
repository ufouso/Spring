package com.xpp.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.config.MyConfigureOne;
import com.xpp.test.domain.Student;
import com.xpp.test.exception.MyException;
import com.xpp.test.repository.StudentRepository;
import com.xpp.test.service.TestPostConstruct;

@RestController
@RequestMapping("/test")
public class SampleController {
	
	@Resource
	private StudentRepository studentRepository;
	
	@Resource
	private MyConfigureOne mo;
	
	
    @RequestMapping("/test1")
    public String home() {
        return "Hello World!";
    }

    /**
     * 测试配置文件
     * @return
     */
//    @RequestMapping(value = "/test2",method=RequestMethod.GET)
    @GetMapping("/test2")
    public String test2(){
    	return "姓名："+mo.getName()+"----年龄："+mo.getAge()+"----图片颜色：";
    }
    
    @GetMapping("/test3")
    public List<Student> findAll(){
    	return studentRepository.findAll();
    }
    
    @GetMapping("/test4")
    public void addStu(){
    	Student s = new Student();
    	s.setAge("12");
    	s.setName("faker");
    	s.setSex("male");
    	studentRepository.save(s);
    }
    
    @GetMapping("/test5")
    public void update(){
    	Student s = studentRepository.findOne(2);
    	s.setName("jimi");
    	studentRepository.save(s);
    }
    
    @GetMapping("/test6")
    public void doExceptionOne() throws Exception{
    	try {
    		String a = null;
    		System.out.println(a.length());
		} catch (MyException e) {
			throw new MyException(e.getErrorCode(), e.getErrorMessage(), e.getCause());
		}
    }

//    @Resource
//    private InterfaceURLs interfaceURLs;
    /**
     * 测试http请求
     * @return
     */
    @GetMapping("/testA")
    public String testA(){
//    	System.out.println(interfaceURLs.getUrls());
    	return "get";
    }
    /**
     * 测试http请求
     * @return
     */
    @PostMapping("/testB")
    public String testB(){
    	return "post";
    }
    
    @Resource
    private TestPostConstruct ts;

//	  获取applicationContext
//     方法一：
//    private static ApplicationContext ac;
//    static{
//    	ac = ContextLoader.getCurrentWebApplicationContext();
//    }
//     方法二：
//    @Resource
//    private ApplicationContext ac;
    
    @GetMapping("/testC")
    public String testC(){
    	ts.destroy();
    	return ts.dosome();
    }
}
