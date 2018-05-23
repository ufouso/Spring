package com.xpp.provider.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class TestServerImpl{

	@Reference(version="1.0.0")
	TestServer testClient;
	
	public String print() {
		return testClient.findSome();
	}

}
