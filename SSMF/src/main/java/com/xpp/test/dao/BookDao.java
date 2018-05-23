package com.xpp.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xpp.test.ioEntity.Book;

/**
 * 数据库操作类
 * @author xpp
 *
 */
public interface BookDao {

	@Select("select * from book")
	public List<Book> findAll();
	
	@Select("select * from book b where b.id=#{id}")
	public Book findById(String id);
	
	@Insert("insert into book value (#{id}, #{bookName}, #{price}, #{press})")
	public int addBook(Book b);
	
	@Delete("delete from book where id=#{id}")
	public void delBook(String id);
	
	@Update("update book set bookName=#{bookName}, price=#{price}, press=#{press} where id=#{id}")
	public int updateBook(String id, String bookName, String price, String press);
	
}
