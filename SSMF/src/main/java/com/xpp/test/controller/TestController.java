package com.xpp.test.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.service.TestService;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@Resource
	private TestService testService;
	
	@PostMapping("/add")
	public void doTest(){
		testService.insertAll();
	}
	
	
	@PostMapping("/del")
	public void doTestOne(String id1, String id2){
		testService.deleteAll(id1, id2);
	}
}
