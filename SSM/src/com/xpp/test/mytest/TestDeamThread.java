package com.xpp.test.mytest;

/**
 * 测试守护线程
 * @author xpp
 *
 */
public class TestDeamThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(){
			public void run(){
				while(true){
					System.out.println("后台线程");
					try {
						Thread.sleep(1000);
						System.out.println("当前线程的状态："+Thread.currentThread().getState());
						System.out.println("判断是否线程中断："+Thread.currentThread().isInterrupted());
						System.out.println("NO.1");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		t.setDaemon(true);
		t.start();
		
		//主线程休眠5秒，t线程为守护线程，所以所有前台线程结束后，守护线程强制结束。
		Thread.sleep(5000);
		
		System.out.println("main线程结束了");
	}
}
