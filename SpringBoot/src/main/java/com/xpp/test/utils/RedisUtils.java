package com.xpp.test.utils;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工具类
 * @author xpp
 *
 */
@Component
public class RedisUtils {
	
	@Autowired
	private JedisPool jedisPool;
	
	private static RedisUtils redisUtils;
	
	@PostConstruct
	private void init(){//这种方法在findDebug工具中，不会被认同。
		redisUtils = this;
		redisUtils.jedisPool = this.jedisPool;
		
//		这种更简便的方法需要上面应用的两个实例用的是同一个类。
//		private JedisPool jedisPool;
//		private static JedisPool redisUtils;
//		RedisUtils.redisUtils = jedisPool;
	}
	/**
	 * 设置字符串
	 * @param key
	 * @param value
	 */
	public static void set(String key, String value){
		Jedis jedis = null;
		try {
			jedis = redisUtils.jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//返还给连接池
			jedis.close();
		}
	}
	
	
	/**
	 * 设置对象
	 * @param key
	 * @param object
	 * @return
	 */
	public static String set(String key, Object object) {
		Jedis jedis = null;
		try {
			jedis = redisUtils.jedisPool.getResource();
			return jedis.set(key.getBytes(), SerializeUtil.serialize(object));
		} finally{
			jedis.close();
		}
	}
	
	/**
	 * 获取字符串的值
	 * @param key
	 * @return
	 */
	public static String get(String key){
		Jedis jedis = null;
		try {
			jedis = redisUtils.jedisPool.getResource();
			return jedis.get(key);
		} finally{
			jedis.close();
		}
	}
	/**
	 * 通过key获取对象
	 * @param key
	 * @return
	 */
	public static Object getObject(String key){
		Jedis jedis = null;
		try {
			jedis = redisUtils.jedisPool.getResource();
			return SerializeUtil.unserialize(jedis.get(key.getBytes()));
		} finally{
			jedis.close();
		}
	}
	
	/** 
	 * 通过key删除（字节） 
	 * @param key 
	 */  
	public void del(String key){  
		Jedis jedis = null;
		try {
			jedis = redisUtils.jedisPool.getResource();  
			jedis.del(key.getBytes());  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
	}  
	
	
  
    /** 
     * 添加key value 并且设置存活时间(byte) 
     * @param key 
     * @param value 
     * @param liveTime 
     */  
    public static void set(String key,String value,int liveTime){  
    	Jedis jedis = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
//    		jedis.set(key.getBytes(), value.getBytes());
//    		jedis.expire(key.getBytes(), liveTime);  
    		jedis.setex(key.getBytes(), liveTime, value.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    }
    
    /**
     * 添加key object 并且设置存活时间(byte)
     * @param key
     * @param obj
     * @param liveTime
     */
    public void set(String key,Object obj,int liveTime){  
    	Jedis jedis = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
    		jedis.setex(key.getBytes(), liveTime, SerializeUtil.serialize(obj));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    }
    
    /**
     * 添加key list 
     * @param <T>
     * @param key
     * @param list
     */
    public static void setList(String key, List<?> list){
    	Jedis jedis = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource();
//    		Gson gson = new Gson();
//    		String a = gson.toJson(list);
    		jedis.set(key.getBytes(), SerializeUtil.serialize(list));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    }
    
    
    /**
     * 通过key获取list
     * @param key
     * @return
     */
    public static <T> List<T> getList(String key){
    	Jedis jedis = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource(); 
//    		Gson gson = new Gson();
//    		String a = (String) SerializeUtil.unserialize(jedis.get(key.getBytes()));
//    		List<T> list = gson.fromJson(a, new TypeToken<List<T>>() {}.getType());
    		List<T> list = (List<T>) SerializeUtil.unserialize(jedis.get(key.getBytes()));
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    	return null;
    }
    
    /** 
     * 通过正则匹配keys 
     * @param pattern 
     * @return 
     */  
//    public Set<String> keys(String pattern){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        Set<String> value = jedis.keys(pattern);  
//        RedisUtils.returnResource(jedis);  
//        return value;  
//    }  
  
    /**
     * 检查key是否已经存在,flag为true则是字节码的形式判断
     * @param key
     * @param flag
     * @return
     */
    public boolean exists(String key, boolean flag){  
    	Jedis jedis = null;
    	boolean eg=false;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
    		if(flag){
    			eg = jedis.exists(key.getBytes());
    		}else{
    			eg = jedis.exists(key);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    	return eg;
    }  
      
    /*******************redis list操作************************/  
    /** 
     * 往list中添加元素 
     * @param key 
     * @param value 
     */  
//    public void lpush(String key,String value){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        jedis.lpush(key, value);  
//        RedisUtils.returnResource(jedis);  
//    }  
//      
//    public void rpush(String key,String value){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        jedis.rpush(key, value);  
//        RedisUtils.returnResource(jedis);  
//    }  
//      
//    /** 
//     * 数组长度 
//     * @param key 
//     * @return 
//     */  
//    public Long llen(String key){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        Long len = jedis.llen(key);  
//        RedisUtils.returnResource(jedis);  
//        return len;  
//    }  
//      
//    /** 
//     * 获取下标为index的value 
//     * @param key 
//     * @param index 
//     * @return 
//     */  
//    public String lindex(String key,Long index){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        String str = jedis.lindex(key, index);  
//        RedisUtils.returnResource(jedis);  
//        return str;  
//    }  
//      
//    public String lpop(String key){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        String str = jedis.lpop(key);  
//        RedisUtils.returnResource(jedis);  
//        return str;  
//    }  
//      
//    public List<String> lrange(String key,long start,long end){  
//        Jedis jedis = redisUtils.jedisPool.getResource();  
//        List<String> str = jedis.lrange(key, start, end);  
//        RedisUtils.returnResource(jedis);  
//        return str;  
//    }  
    /*********************redis list操作结束**************************/  
      
    /** 
     * 清空redis 所有数据 
     * @return 
     */  
    public String flushDB(){  
        Jedis jedis = null;
        String str = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
    		str = jedis.flushDB();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
    	return str;
    }  
    /** 
     * 查看redis里有多少数据 
     */  
    public long dbSize(){  
    	Jedis jedis = null;
    	long len= 0L;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
    		len = jedis.dbSize();   
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
        return len;  
    }  
    /** 
     * 检查是否连接成功 
     * @return 
     */  
    public String ping(){  
        Jedis jedis = null;  
        String str = null;
    	try {
    		jedis = redisUtils.jedisPool.getResource();  
    		str = jedis.ping();     
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.close();
		}
        return str;
    }  
	
}
