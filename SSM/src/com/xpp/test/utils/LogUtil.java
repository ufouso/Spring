package com.xpp.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用slf4j创建对象，好处是，以后更换其他日志工具时，只要修改配置文件，而不用修改代码
 * slf4j日志工具类。
 * @author xpp
 *
 */
public class LogUtil {
	
	private static Logger log = LoggerFactory.getLogger(LogUtil.class);
	
	public static void error(String message){
		log.error(message);
	}
	
	public static void error(String code, String message){
		log.error(code, message);
	}
	
	public static void debug(String message){
		log.debug(message);
	}
	
	public static void debug(String code, String message){
		log.debug(code, message);
	}
	
	public static void info(String message){
		log.info(message);
	}
	
	public static void info(String code, String message){
		log.info(code, message);
	}
	
	
}
