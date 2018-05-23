//package com.xpp.test.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//@Component
//public class RedisConfig_Spring {
//	
//	private Logger log = LoggerFactory.getLogger(getClass());
//	
//	/**
//	 * 获取redis连接配置
//	 * @return
//	 */
//	@Bean
//	@ConfigurationProperties(prefix="spring.redis")
//	public JedisPoolConfig getPoolConfig(){
//		log.info("获取redis连接配置");
//		JedisPoolConfig config = new JedisPoolConfig();
//		return config;
//	}
//	
//	/**
//	 * 进行redis连接
//	 * @return
//	 */
//	@Bean
//	@ConfigurationProperties(prefix="spring.redis")
//	public JedisConnectionFactory getConnectionFactory(){
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		JedisPoolConfig config = factory.getPoolConfig();
//		factory.setPoolConfig(config);
//		log.info("JedisConnectionFactory bean init success.");
//		return factory;
//	}
//	
//	
//	public RedisTemplate<?, ?> getredisTemplate(){
//		RedisTemplate<?, ?>  template = new StringRedisTemplate(getConnectionFactory());
//		return template;		
//	}
//	
//}
