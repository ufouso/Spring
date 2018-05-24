//package com.xpp.test.mytest;
//
//import javax.annotation.Resource;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.xpp.test.dao.StudentDao;
//import com.xpp.test.ioEntity.Student;
//import com.xpp.test.service.StudentService;
//  
////@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
//  
//public class Test {  
//	
//    @Resource  
//    private StudentService studentService;  
//  
////  @Before  
////  public void before() {  
////      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
////      userService = (IUserService) ac.getBean("userService");  
////  }  
//  
////    @org.junit.Test
////    public void test1() {  
////    	Student student = studentService.findByStuId("1");
////    	System.out.println(student.toString());
////    }  
////    
//    
//    @org.junit.Test
//    public void test2(){
//    	ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//    	StudentDao dao = ctx.getBean(StudentDao.class);
//    	Student s = dao.findById("1");
//    	System.out.println(s.toString());
//    }
//}  