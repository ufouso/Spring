package com.xpp.provider.domain;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = -5991494722005124444L;

	private String name;
	
	private String price;
	
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", address=" + address + "]";
	}
	
}
