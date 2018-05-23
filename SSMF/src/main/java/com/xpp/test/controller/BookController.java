package com.xpp.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpp.test.ioEntity.Book;
import com.xpp.test.service.BookService;

@RequestMapping("/book")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/findAll")
	public List<Book> getAllBook(){
		return bookService.findAll();
	}
	
}
