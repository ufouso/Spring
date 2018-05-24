package com.xpp.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource(value={"classpath:spring.xml"})
public class Application {
	
//	extends SpringBootServletInitializer
//	 @Override
//	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		 System.out.println("我要开始SpringBoot开启了，ready go.");
//	   // 注意这里要指向原先用main方法执行的Application启动类
//	   return builder.sources(Application.class);
//	 }
//	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
