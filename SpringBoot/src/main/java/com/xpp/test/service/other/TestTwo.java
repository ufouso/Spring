package com.xpp.test.service.other;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureOrder(5)
public class TestTwo {
	
	@Bean
	public B b(){
		System.out.println("TestTwo");
		return new B();
	}
	
}
