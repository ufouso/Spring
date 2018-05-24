package com.xpp.test.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.activation.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.xpp.test.config.DataSourceManager;
import com.xpp.test.config.DataSources;
import com.xpp.test.utils.LogUtil;

@Component
@Aspect
public class Aspect1 {
	
	//执行顺序: 先执行前置，逻辑代码，  后置，最终(通过动态代理重写了目标功能组件和方面功能组件)
	@Before("within(com.xpp.test.controller..*)")
	public void logOne(){
		LogUtil.info("AOP前置通知");
	}

	@AfterReturning("within(com.xpp.test.controller..*)")
	public void LogThree(){
		LogUtil.info("AOP后置通知");
	}
	
	@After("within(com.xpp.test.controller..*)")
	public void logTwo(){
		LogUtil.info("AOP最终通知");
	}
	
//	@Around("within(com.xpp.test.controller..*)") //service添加aop，执行顺序前置，逻辑代码，环绕，后置，最终
//	public void LogFour(){
//		LogUtil.info("AOP环绕通知");
//	}
	
	@Around("within(com.xpp.test.controller..*)")
	public Object LogFive(ProceedingJoinPoint p) throws Throwable{ //执行顺序 前置通知，环绕通知1，逻辑代码，后置通知，最终通知，环绕通知2
		//此处代码在目标组件前执行
		DataSourceManager.set(DataSources.db2);
		LogUtil.info("AOP环绕通知1");
		String className = p.getTarget().getClass().getName();//获取目标组件的类名
		String methodName = p.getSignature().getName();		 //获取目标组件的方法名
		 if (isSlave(methodName)) {
	            // 标记为从库
			 	DataSourceManager.set(DataSources.db2);
	        } else {
	            // 标记为主库
	        	DataSourceManager.set(DataSources.db1);
	        }
		
		LogUtil.info("开始调用："+className+"."+methodName+"()");
		Object object = p.proceed();//执行目标组件
		LogUtil.info("调用结束");
		//此处代码在目标组件后执行
		LogUtil.info("AOP环绕通知2");
		return object;
	}
	
	@AfterThrowing(pointcut="within(com.xpp.test.controller..*)",throwing="e") //异常通知
	public void LogFour(Exception e){
		LogUtil.info("异常通知");
	}
	
//	@Pointcut("execution(public * com.xpp.test..*.addStudent(..))")
//	public void dataS(){
//		LogUtil.info("进行切面，设置数据源");
//		System.out.println("fakerfaker");
//	}
	
//	@Pointcut("execution(public * com.xpp.test..*.addStudent(..))")
//	public void dataSourcess1(){
//		DataSourceManager.set(DataSources.db2);
//	}

	/**
	 * 判断是否为读库
	 * 
	 * @param methodName
	 * @return
	 */
	private Boolean isSlave(String methodName) {
		// 方法名以query、find、get开头的方法名走从库
		return StringUtils.startsWithAny(methodName, "query", "find", "get", "select");
	}
	
}
