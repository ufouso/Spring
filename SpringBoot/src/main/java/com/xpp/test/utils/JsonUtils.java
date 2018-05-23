package com.xpp.test.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * json工具类，使用的是google的gson和alibaba的fastjson
 * 需要引入两个jar包
 * FastJson在复杂类型的Bean转换Json上会出现一些问题，可能会出现引用的类型，导致Json转换出错，需要制定引用。
 * 有性能上面的要求可以使用Gson将bean转换json确保数据的正确，使用FastJson将Json转换Bean
 * @author xpp
 *
 */
public class JsonUtils {
	
	private static Logger log = LoggerFactory.getLogger(JsonUtils.class);
	
	/**
	 * 对象转json使用的gson
	 * @return
	 */
	public static String BeanToJson(Object obj){
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}
	
	/**
	 * json 转对象，使用fastjson
	 * @return
	 */
	public static Object JsonToBean(String json){
		Object obj = JSON.parseObject(json);
		return obj;
	}
	
	/**
	 * list转json
	 * @param list
	 * @return
	 */
	public static String ListToJson(List<?> list){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	
	/**
	 * json转list
	 * @param json
	 * @param cls 类型
	 * @return
	 */
	public static List<?> JsonToList(String json,Class<?> cls){
		List<?> list = JSON.parseArray(json, cls);
		return list;
	}
	
	/**
	 * map 转 json
	 * @param map
	 * @return
	 */
	public static String MapToJson(Map<?, ?> map){
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	
	/**
	 * json 转map
	 * @param json
	 * @return
	 */
	public static Map<?,?> JsonToMap(String json){
		Map<?,?> map = JSON.parseObject(json);
		return map;
	}
	
	
	public static void main(String[] args) {
		//=============测试list转json========================
//		List<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("bf");
//		list.add("福利");
//		list.add("&&&&:");
//		//list转json:["a","b","bf","福利","\u0026\u0026\u0026\u0026:"]
//		String json = ListToJson(list);
//		log.info("list转json:"+ json);
//		
//		List<String> lista = (List<String>) JsonToList(json, String.class);
//		for(String f : lista){
//			System.out.println(f);
//		}
		//=========================================================
//		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		Map<String, Object> map3 = new HashMap<String, Object>();
//		map1.put("no1", "no1");
//		map1.put("no11", "no11");
//		map2.put("no2", "no2");
//		map3.put("no3", "no3");
//		list2.add(map1);
//		list2.add(map2);
//		list2.add(map3);
//		//list转json[{"no1":"no1","no11":"no11"},{"no2":"no2"},{"no3":"no3"}]
//		String json2 = ListToJson(list2);
//		log.info("list转json"+json2);
//		List<Map<String, Object>> listb = (List<Map<String, Object>>) JsonToList(json2, HashMap.class);
		//=============================================================================================
//		List<Student> list3 = new ArrayList<Student>();
//		Student s1 = new Student();
//		s1.setAge("1");
//		s1.setName("张三");
//		s1.setSex("faker1");
//		Student s2 = new Student();
//		s2.setAge("2");
//		s2.setName("李四");
//		s2.setSex("faker2");
//		Student s3 = new Student();
//		s3.setAge("3");
//		s3.setName("王五");
//		s3.setSex("faker3");
//		list3.add(s1);
//		list3.add(s2);
//		list3.add(s3);
//		//[{"name":"张三","age":"1","sex":"faker1"},{"name":"李四","age":"2","sex":"faker2"},{"name":"王五","age":"3","sex":"faker3"}]
//		String json = ListToJson(list3);
//		log.info("list转json:"+ json);
//		
//		List<Student> listc = (List<Student>) JsonToList(json, Student.class);
//		System.out.println(""+listc.get(0).getName());
		
		//========================map转json==========================================
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "张三");
//		map.put("age", "18");
//		map.put("sex", "males");
//		
//		String json = MapToJson(map);
//		log.info("map转Json:"+ json);
//		
//		Map<String, Object> maps = (Map<String, Object>) JsonToMap(json);
//		Iterator<Entry<String, Object>> it = maps.entrySet().iterator();
//		while(it.hasNext()){
//			Map.Entry<String, Object> mapf = it.next();
//			System.out.println(mapf.getKey()+":"+mapf.getValue());
//		}
	}
	
}
