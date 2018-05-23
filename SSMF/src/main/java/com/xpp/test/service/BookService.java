package com.xpp.test.service;

import java.util.List;

import com.xpp.test.ioEntity.Book;

public interface BookService {

	public List<Book> findAll();
	
	public Book findById(String id);
	
	public int addBook(Book b);
	
	public void delBook(String id);
	
	public void updateBook(String id, String bookName, String price, String press);
}
