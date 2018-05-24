package com.xpp.test.mytest;

import java.util.Date;

public class TestThread2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread (){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("当前时间:"+new Date());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

