package com.xpp.test.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当我们使用RESTful API时，异常统一处理类，如果出现异常想跳专门的错误页面，也能实现
 * @author xpp
 *
 */
@ControllerAdvice(annotations={Controller.class, RestController.class})
public class MyExceptionHandler {
	
	/**
	 * 统一对MyException的异常进行处理
	 */
	//用于全局处理控制器里的异常。
	//	@ExceptionHandler在此处定义全局处理，
	//	通过@ExceptionHandler的value属性可过滤拦截的条件，不写则是拦截所有的Exception。
	@ExceptionHandler(value={MyException.class})
	@ResponseBody
	public Map<String, Object> defaultErrorHandler(HttpServletRequest request, MyException m) throws Exception {
		String code = m.getErrorCode();
		String message = m.getErrorMessage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
//		map.put("urls", request.getRequestURL());
		return map;
	}
}
