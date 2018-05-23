package com.xpp.test.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 这种方法不好将对象直接set进入redis缓存中。要传对象的话，需要特定的实体来传
 * @author xpp
 *
 */
public class RedisUtils_Spring {
	 
	    private static RedisTemplate<String, ?> redisTemplate;  
	
	    public static boolean set(final String key, final String value) {  
	        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            @Override  
	            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                connection.set(serializer.serialize(key), serializer.serialize(value));  
	                return true;  
	            }  
	        });  
	        return result;  
	    }  
	    
	  
	    public static String get(final String key){  
	        String result = redisTemplate.execute(new RedisCallback<String>() {  
	            @Override  
	            public String doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                byte[] value =  connection.get(serializer.serialize(key));  
	                return serializer.deserialize(value);  
	            }  
	        });  
	        return result;  
	    }  
	  
	    public static boolean expire(final String key, long expire) {  
	        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);  
	    }  
	  
	    public static boolean setObject(String key, Object obj){
	    	Gson gson = new Gson();
	    	String value = gson.toJson(obj);
	    	return set(key, value);
	    }
	    
	    public static <T> T getObject(String key, Class<T> clz){
	    	String value = get(key);
	    	Gson g = new Gson();
	    	return g.fromJson(value, clz);
	    }
	    
	    public static <T> boolean setList(String key, List<T> list) {  
	    	Gson gson = new Gson();
	        String value = gson.toJson(list);  
	        return set(key,value);  
	    }  
	  
	    public static <T> List<T> getList(String key,Class<T> clz) {  
	        String json = get(key);  
	        if(json!=null){ 
	        	Gson gson = new Gson();
	        	List<T> list = gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
	            return list;  
	        }  
	        return null;  
	    }  
	  
	    public static long lpush(final String key, Object obj) {  
	    	Gson gson = new Gson();
	        final String value = gson.toJson(obj);  
	        long result = redisTemplate.execute(new RedisCallback<Long>() {  
	            @Override  
	            public Long doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));  
	                return count;  
	            }  
	        });  
	        return result;  
	    }  
	  
	    public static long rpush(final String key, Object obj) {  
	    	Gson gson = new Gson();
	        final String value = gson.toJson(obj);  
	        long result = redisTemplate.execute(new RedisCallback<Long>() {  
	            @Override  
	            public Long doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));  
	                return count;  
	            }  
	        });  
	        return result;  
	    }  
	  
	    public static String lpop(final String key) {  
	        String result = redisTemplate.execute(new RedisCallback<String>() {  
	            @Override  
	            public String doInRedis(RedisConnection connection) throws DataAccessException {  
	                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
	                byte[] res =  connection.lPop(serializer.serialize(key));  
	                return serializer.deserialize(res);  
	            }  
	        });  
	        return result;  
	    }

		public RedisTemplate<String, ?> getRedisTemplate() {
			return redisTemplate;
		}

		public void setRedisTemplate(RedisTemplate<String, ?> redisTemplate) {
			this.redisTemplate = redisTemplate;
		}  
}
