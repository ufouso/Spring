package com.xpp.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xpp.provider.service.TestServer;

/**
 * dubbo服务提供方
 * @author xpp
 *
 */
@Service(version="1.0.0")
public class TestServerImpl implements TestServer {

	@Override
	public String findSome() {
		String a = "Do you love me?";
		return a;
	}

}
