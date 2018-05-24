package com.xpp.test.mytest;

public class TestTwo {
	
	public static void main(String[] args) {
		System.out.println("main的线程："+Thread.currentThread());//返回结果为：Thread[main,5,main]
//		1.
//		Thread t1 = new MyThread();
//		Thread t2 = new MyThread();
//		t1.start();
//		t2.start();
		
//		2.
//		ThreadOne to = new ThreadOne();
//		Thread r = new Thread(to);
//		r.start();
	
//		3.
		Thread  t = new Thread(){ //使用匿名内部类
			public void run(){
				//输出结果为：Thread[Thread-0,5,main],表示线程的名称为“Thread-0”，优先级为5，当前线程的主线程为main;
				System.out.println("test线程的："+Thread.currentThread());
				
				int i=0;
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i = i==0?1:0;
					if(i==0){
						System.out.println("a");
					}else{
						System.out.println("b");
					}
				}
			}
		}; 
		t.start();
	}
}

class MyThread extends Thread{ //继承Thread线程，重写run方法。
	public void run(){
		for(int i=0;i<100;i++){
			 System.out.println(i);
		}
	}
}


class ThreadOne implements Runnable{ //实现Runable接口，

	@Override
	public void run() {
		int i=0;
		while(true){
			i= i==0?1:0;
			if(i==0){
				System.out.println("a");
			}else{
				System.out.println("b");
			}
		}
		
	}
}

