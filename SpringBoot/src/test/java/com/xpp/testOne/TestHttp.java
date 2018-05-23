package com.xpp.testOne;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.xpp.test.utils.HttpUtils;

public class TestHttp {

	
	public static String doGet(String url){
		String content = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response =null;
		try {
			//执行get请求
			response = httpClient.execute(httpGet);
			//打印响应状态
			System.out.println("响应状态："+response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if(entity != null){
				System.out.println("响应内容长度："+entity.getContentLength());
				content = EntityUtils.toString(entity);
				System.out.println("响应内容："+content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(response!=null){
					response.close();
				}
				//关闭连接释放资源
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return content;
	
	}
	
	public void doPost(){
		
	}
	
	public static void main(String[] args) {
//		String a = HttpUtils.get("http://localhost:8080/SpringBoot/test/testA");
//		System.out.println(a);
		try {
			String b = HttpUtils.post("http://localhost:8080/SpringBoot/test/testB", null);
			System.out.println(b);
//			List<String> urls = new ArrayList<String>();
//			
//			urls.add("http://127.0.0.1:8081");
//			urls.add("http://127.0.0.1:8080");
//			String c = HttpUtils.sendOnePost(urls, "/SpringBoot/test/testB", null);
//			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("===============================================");
		String a = doGet("http://localhost:8080/SpringBoot/test/testA");
		System.out.println(a);
		
	}
}
