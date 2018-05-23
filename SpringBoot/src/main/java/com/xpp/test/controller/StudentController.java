package com.xpp.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.xpp.test.domain.Student;
import com.xpp.test.service.ServiceA;
import com.xpp.test.utils.RedisUtils;
import com.xpp.test.utils.RedisUtils_Spring;

/**
 * 测试redis的工具类
 * @author xpp
 *
 */
@RestController
@RequestMapping("/redis")
public class StudentController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RedisTemplate<String, ?> redisTemplate; 
	
	@GetMapping("/findOne")
	public String doOne(){
		RedisUtils_Spring r = new RedisUtils_Spring();
		r.setRedisTemplate(redisTemplate);
		r.set("faker", "NB");
		Student s = new Student();
		s.setAge("18");
		s.setName("张三");
		s.setSex("男");
		r.setObject("student", s);
		return "Success";
	}
	
	@GetMapping("findTwo")
	public String doTwo(){
		RedisUtils_Spring r = new RedisUtils_Spring();
		r.setRedisTemplate(redisTemplate);
		String value = r.get("faker");
		Student s = r.getObject("student", Student.class);
		return s.getName();
	}
	
	
	@GetMapping("/findThree")
	public String doThree(){
		try {
			RedisUtils.set("aluka", "坦克");
			
			Student s = new Student();
			s.setAge("18");
			s.setName("刘翔");
			s.setSex("male");
			RedisUtils.set("student", s);
			
			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("d");
			list.add("e");
			RedisUtils.setList("listOne", list);
			
			Student s1 = new Student();
			s1.setAge("18");
			s1.setName("刘翔");
			s1.setSex("male");
			Student s2 = new Student();
			s2.setAge("19");
			s2.setName("刘翔1");
			s2.setSex("male1");
			Student s3 = new Student();
			s3.setAge("20");
			s3.setName("刘翔2");
			s3.setSex("male2");
			List<Student> myList = new ArrayList<Student>();
			myList.add(s1);
			myList.add(s2);
			myList.add(s3);
			RedisUtils.setList("stuList", myList);
			
			List<Map<String, Object>> ll = new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>(); 
			map1.put("no1", "no1");
			Map<String, Object> map2 = new HashMap<String, Object>(); 
			map2.put("no2", "no2");
			Map<String, Object> map3 = new HashMap<String, Object>(); 
			map3.put("no3", "no3");
			ll.add(map1);
			ll.add(map2);
			ll.add(map3);
			RedisUtils.setList("ll", ll);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}
	
	@GetMapping("/findFour")
	public String doFour(){
		String a = RedisUtils.get("aluka");
		Student s = (Student) RedisUtils.getObject("student");
		Gson gson = new Gson();
		log.info("学生的具体信息："+gson.toJson(s));
		
		List<String> list = RedisUtils.getList("listOne");
		log.info("list列表："+gson.toJson(list));
		
		List<Student> myList = RedisUtils.getList("stuList");
		log.info("学生列表："+ gson.toJson(myList)+"----"+myList.get(0).getName());
		
		List<Map<String, Object>> ll = RedisUtils.getList("ll");
		log.info("maplist"+gson.toJson(ll));
		
		return a;
	}
	
	/**
	 * 测试有生存时间的redis缓存。同时支持post和get请求
	 * @return
	 */
//	@GetMapping("/findFive")
	@RequestMapping(value="/findFive",method={RequestMethod.GET,RequestMethod.POST})
	public String doFive(){
		RedisUtils.set("faker", "Asidonmading", 5);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String a = RedisUtils.get("faker");
		return a;
	}
	
	@Autowired
	private ServiceA serviceA;
	
	
	@RequestMapping(value="/findSix",method={RequestMethod.GET,RequestMethod.POST})
	public void doSix(){
		serviceA.methodA();
	}
}
