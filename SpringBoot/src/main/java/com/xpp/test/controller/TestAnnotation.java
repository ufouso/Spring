package com.xpp.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.annotation.CheckSome2;

/**
 * 测试
 * @author xpp
 *
 */
@RestController
@RequestMapping("/testAnnotation")
public class TestAnnotation {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@CheckSome2
	private String num;
	
	@CheckSome2
	private String money;
	
	@CheckSome2
	private Integer show;
	
	@PostMapping("/testOne")
	public void doOne() {
		logger.info(num+"====="+money+"====="+show);
	}
}
