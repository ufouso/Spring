package com.xpp.test.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.service.Shopping;

/**
 * 测试动态代理和静态代理
 * @author xpp
 *
 */
@RequestMapping("/proxy")
@RestController
public class TestProxyController {
	
	@Resource
	private Shopping shop;
	
	/**
	 * 测试静态代理
	 */
	@GetMapping("/testOne")
	public void testOne(){
		shop.buySomething();
	}
	
	/**
	 * 测试动态代理
	 */
	@GetMapping("/testTwo")
	public void testTwo(){
		
	}
}
