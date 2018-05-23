package com.xpp.test.ioEntity;

public class Train {
	
	private String id;
	
	private String owner;
	
	private String sign;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", owner=" + owner + ", sign=" + sign + "]";
	}

}
