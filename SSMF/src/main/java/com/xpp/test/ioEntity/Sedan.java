package com.xpp.test.ioEntity;
/**
 * 轿车
 * @author xpp
 *
 */
public class Sedan {
	
	private String id;
	//拥有人
	private String owner;
	//品牌
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
		return "Sedan [id=" + id + ", owner=" + owner + ", sign=" + sign + "]";
	}
	
}
