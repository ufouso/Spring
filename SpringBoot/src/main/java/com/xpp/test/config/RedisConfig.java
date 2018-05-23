package com.xpp.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConfigurationProperties(prefix="spring.redis")
public class RedisConfig extends CachingConfigurerSupport{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
//	public ConfigureRedisAction configureRedisAction(){
//		return ConfigureRedisAction.NO_OP;
//	}
	
	private String database;
	
	private String host;
	
	private int port;
	
	private String password;

	//连接超时时间（毫秒）
	private int timeout;
	
	//最大连接数
	@Value("${spring.redis.pool.max-active}")
	private int maxActive;
	
	//最大阻塞等待时间（为负数表示不限制）
	@Value("${spring.redis.pool.max-wait}")
	private int maxWait;
	
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;
	
	@Value("${spring.redis.pool.min-idle}")
	private int minIdle;

	@Bean
	public JedisPool redisPoolFactory(){
		log.info("redispool注入成功");
		log.info("redis地址："+host+"----端口："+port);
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMinIdle(minIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWait);
		jedisPoolConfig.setMaxTotal(maxActive);
		log.info("redisPool开始连接");
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
		return jedisPool;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getTimeout() {
		return timeout;
	}


	public void setTimout(int timout) {
		this.timeout = timout;
	}


	public int getMaxActive() {
		return maxActive;
	}


	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}


	public int getMaxWait() {
		return maxWait;
	}


	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}


	public int getMaxIdle() {
		return maxIdle;
	}


	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}


	public int getMinIdle() {
		return minIdle;
	}


	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	
}
