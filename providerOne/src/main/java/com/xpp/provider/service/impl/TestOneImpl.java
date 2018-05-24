package com.xpp.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.xpp.provider.domain.Book;
import com.xpp.provider.service.TestOne;

@Service(version="1.0.1")
public class TestOneImpl implements TestOne {

	@Override
	public List<Book> findBooks() {
		Book b1 = new Book();
		b1.setAddress("北京");
		b1.setName("三国演义");
		b1.setPrice("18");
		
		Book b2 = new Book();
		b2.setAddress("南京");
		b2.setName("红楼梦");
		b2.setPrice("20");
		
		Book b3 = new Book();
		b3.setAddress("杭州");
		b3.setName("水浒传");
		b3.setPrice("25");
		List<Book> list = new ArrayList<Book>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		return list;
	}
	
	
}
