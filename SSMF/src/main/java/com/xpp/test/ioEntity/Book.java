package com.xpp.test.ioEntity;
/**
 * 书本的实体类
 * @author xpp
 *
 */
public class Book {
	
	private String id;
	
	private String bookName;
	
	private String price;
	
	private String press;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", press=" + press + "]";
	}
	
}
