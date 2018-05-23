package com.xpp.test.service.impl;

import org.springframework.stereotype.Service;

import com.xpp.test.service.Shopping;

/**
 * 
 * @author xpp
 *
 */
@Service
public class ShoppingImpl implements Shopping {

	@Override
	public void buySomething() {
		System.out.println("购买东西！");
	}

}
