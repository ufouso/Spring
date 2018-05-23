package com.xpp.test.service.proxy;

import com.xpp.test.service.Shopping;
import com.xpp.test.service.impl.ShoppingImpl;

/**
 * 静态代理的方法
 * @author xpp
 *
 */
public class ProxyShopping implements Shopping{
	
	private ShoppingImpl si;
	
	//构造方法
	public ProxyShopping(ShoppingImpl si){
		this.si = si;
	}

	@Override
	public void buySomething() {
		si.buySomething();
		System.out.println("faker");
	}

}
