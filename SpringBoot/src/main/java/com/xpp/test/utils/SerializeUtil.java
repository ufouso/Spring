package com.xpp.test.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化和反序列化工具类
 * @author xpp
 *
 */
public class SerializeUtil {
	
	/**
	 * 对象序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(baos !=null){
					baos.close();
				}
				if(oos !=null){
					oos.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 对象反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		ObjectInputStream  ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {  
				if (bais != null){
					bais.close();
				}
				if (ois != null){
					ois.close(); 
				}
            } catch (Exception e2) {  
                e2.printStackTrace();  
            } 
		}
		return null;
	}
	
	/**
	 * TODO
	 * @param in
	 * @return
	 */
//	public static Object deserialize(byte[] in) {
//		Object rv = null;
//		ByteArrayInputStream bis = null;
//		ObjectInputStream is = null;
//		try {
//			if (in != null) {
//				bis = new ByteArrayInputStream(in);
//				is = new ObjectInputStream(bis);
//				rv = is.readObject();
//				is.close();
//				bis.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (is != null)
//					is.close();
//				if (bis != null)
//					bis.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return rv;
//	}
}
