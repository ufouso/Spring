package com.xpp.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 这个是自定义配置文件，低版本的springBoot可以使用location在@ConfigurationProperties中，高版本取消了，所以做以下修改
 * 使用@PropertySource这个配置来进行添加不在默认目录下的资源文件。
 * @author xpp
 *
 */
@ConfigurationProperties(prefix="ICenter")
@Component
@PropertySource(value="classpath:config/application-icenter.properties", ignoreResourceNotFound=true)
public class InterfaceURLs {
	
	private String urls;

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		return "InterfaceURLs [urls=" + urls + "]";
	}

}
