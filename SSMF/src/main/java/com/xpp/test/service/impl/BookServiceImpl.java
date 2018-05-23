package com.xpp.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xpp.test.dao.BookDao;
import com.xpp.test.ioEntity.Book;
import com.xpp.test.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao bookDao;
	
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findById(String id) {
		return bookDao.findById(id);
	}

	@Override
	public int addBook(Book b) {
		return bookDao.addBook(b);
	}

	@Override
	public void delBook(String id) {
		bookDao.delBook(id);
	}

	@Override
	public void updateBook(String id, String bookName, String price, String press) {
		bookDao.updateBook(id, bookName, price, press);
	}

}
