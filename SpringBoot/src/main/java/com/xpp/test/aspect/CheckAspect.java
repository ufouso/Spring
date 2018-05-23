package com.xpp.test.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

@Aspect
@Component
public class CheckAspect {
	
	private Logger  log = LoggerFactory.getLogger(CheckAspect.class);
	
	@Before("log()")
	public void doBefore(){
		log.info("aop前置通知");
		//获取URL
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		StringBuffer URL = request.getRequestURL();
		log.info("请求的URL路径："+URL);
		String method = request.getMethod();
		log.info("请求的方法名："+method);
//		request.get
		
	}
	
	@AfterReturning("log()")
	public void doAfterReturn(){
		log.info("aop后置通知");
	}
	
	@After("log()")
	public void doAfter(){
		log.info("aop最终通知");
	}
	
	@Around("log()")
	public Object doAround(ProceedingJoinPoint p) throws Throwable{
		//获取目标方法的类名
		String className = p.getTarget().getClass().getName();
		//获取目标方法名
		String methodName = p.getSignature().getName();
		log.info("环绕通知执行前,执行："+className +":::"+methodName+"方法");
		Object object = p.proceed();//执行目标组件
		log.info("目标方法执行完毕");
//		System.out.println();
		//GSON bean转JSON快，fasterJson----json转bean快。
		Gson gson = new Gson();
		String str = gson.toJson(object);
		log.info("执行组件的返回："+str);
		@SuppressWarnings("unused")
		Object obj = JSON.parseObject(str, Object.class);
		return object;
	}
	
	@AfterThrowing(pointcut = "within(com.xpp.test.controller..*)",throwing = "e")
	public void doException(){//异常通知
		System.out.println("异常通知");
	}
	
	
	@Pointcut("execution(public * com.xpp.test.controller..*(..))")
	public void log(){
		log.info("公共的");
	}
	
}
