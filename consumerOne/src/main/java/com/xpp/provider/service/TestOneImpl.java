package com.xpp.provider.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xpp.provider.domain.Book;

@Component
public class TestOneImpl {
	
	@Reference(version="1.0.1")
	TestOne testOne;
	
	public List<Book> get(){
		return testOne.findBooks();
	}
}
