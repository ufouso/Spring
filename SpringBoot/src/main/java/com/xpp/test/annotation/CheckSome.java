package com.xpp.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author xpp
 *
 */
//元注解： RetentionPolicy.RUNTIME:注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时，所以他们可以用反射的方式读取
//		  RetentionPolicy.CLASS: 注解的信息只会保留在class文件中，但是在jvm运行时，是不会被读取到的
//		  RetentionPolicy.SOURCE:注解的信息只会保留在源文件中，不会保留在class文件中。

@Retention(RetentionPolicy.RUNTIME)
//元注解：表示该注解只能修饰在方法上
@Target(ElementType.METHOD)
//表示会被javaDoc工具记录
@Documented
public @interface CheckSome {
	
	/**
	 * 测试一
	 * @return
	 */
	public boolean checkOne();
	
	/**
	 * 测试二
	 * @return
	 */
	public boolean checkTwo();
}
