package com.xpp.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.exception.MyException;

@RequestMapping("/test")
@RestController
public class ExceptionController {
	
	@RequestMapping(value="/testException", method={RequestMethod.GET,RequestMethod.POST})
	public String test() throws Exception{
		throw new MyException("001", "异常");
	}
	
}
