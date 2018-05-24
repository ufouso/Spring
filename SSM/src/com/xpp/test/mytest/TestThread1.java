package com.xpp.test.mytest;

public class TestThread1 {
	
	public static void main(String[] args) {
		
//		Thread t1 = new ThreadPNG();
		ThreadPNG1 png = new ThreadPNG1();
		Thread t2 = new Thread(png);
//		t1.start();
		t2.start();
		
//		Thread tt1 = new Thread(){
//			public void run(){
//				for(int i=0;i<=100;){
//					System.out.println("图片加载中："+i+"%");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					i=i+10;
//				}
//			}
//		};
//		
//		Thread tt2 = new Thread(){
//			public void run(){
//				System.out.println("等待图片加载完成！");
//				try {
//					tt1.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("加载完成");
//			}
//		};
//		
//		tt1.start();
//		tt2.start();
		
	}
}

class ThreadPNG extends  Thread{
	public void run(){
		System.out.println("线程启动中，状态为："+Thread.currentThread().isAlive());
		for(int i=0;i<=100;){
			System.out.println("图片加载中："+i+"%");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i=i+10;
		}
		
	}
}

class ThreadPNG1 implements Runnable{
	
	public void run(){
		System.out.println("等待图片加载完成");
		try {
			Thread t = new ThreadPNG();
			t.start();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("图片加载完成！");
	}
	
}