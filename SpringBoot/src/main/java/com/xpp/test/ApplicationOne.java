package com.xpp.test;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//禁止特定的自动配置,需要添加（exclude={DataSourceAutoConfiguration.class}）
//@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class}) //import了 EnableAutoConfigurationImportSelector.class类，这个类就会配合Configuration来使用的，
//用来导出更多的Configuration类，ConfigurationClassPostProcessor会读取Import的内容来实现具体的逻辑，
//EnableAutoConfigurationImportSelector实现了DeferredImportSelector接口,并实现了selectImports方法，用来导出Configuration类。读取到tomcat容器
//@Configuration  //相当于xml中的beans标签
//@ComponentScan //扫描创建bean

//TODO 导入额外的配置类
//@Import(value=Object.class)
//TODO 加载xml配置文件
//@ImportResource(value = "a.xml")


@SpringBootApplication  
public class ApplicationOne {
	
//	 @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
//        return application.sources(Application.class);  
//    } 
	
	
    public static void main(String[] args) {
    	System.out.println("faker大魔王。-=-==-=-===========");
    	SpringApplication app = new SpringApplication(ApplicationOne.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
	
}
