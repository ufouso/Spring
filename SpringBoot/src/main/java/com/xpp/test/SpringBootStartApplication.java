package com.xpp.test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法,
 * 此方法相当于实现了web.xml的功能。（使用tomcat启动时需要）
 * @author xpp
 *
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 System.out.println("我要开始SpringBoot开启了，ready go.");
	   // 注意这里要指向原先用main方法执行的Application启动类
	   return builder.sources(ApplicationOne.class);
	 }
	 
}