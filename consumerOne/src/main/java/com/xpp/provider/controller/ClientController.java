package com.xpp.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.provider.domain.Book;
import com.xpp.provider.service.TestOneImpl;
import com.xpp.provider.service.TestServerImpl;

@RestController
@RequestMapping("/testClient")
public class ClientController {

	@Autowired
	private TestServerImpl testClient;
	
	@Autowired
	private TestOneImpl testOneImpl;
	
	@GetMapping("/testClient")
	public String doSome(){
		return testClient.print();
	}
	
	@GetMapping("/testOne")
	public List<Book> findAll(){
		return testOneImpl.get();
	}
}
