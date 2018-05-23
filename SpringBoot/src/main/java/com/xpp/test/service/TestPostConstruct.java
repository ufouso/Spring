package com.xpp.test.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class TestPostConstruct {
	
	public String dosome(){
		System.out.println("doSome");
		return "didi";
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init初始化");
	}
	
	
	@PreDestroy
	public void destroy(){
		System.out.println("销毁");
	}
}
