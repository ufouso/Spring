package com.xpp.test.mytest;

public class TestThread {
	
	public static void main(String[] args) {
		TestThreadOne to = new TestThreadOne();
		Thread t = new Thread(to);
		t.start();
		
		
		Thread tt = new TestThreadTwo();
		tt.start();
		System.out.println("获取主线程的信息："+Thread.currentThread());
		
		//自定义线程
		Thread t3 = new Thread("faker");
		System.out.println("自定义线程的名字："+t3.getName());
		
	}
}

class TestThreadOne implements Runnable {

	@Override
	public void run() {
		System.out.println("获取当前线程1："+Thread.currentThread());
		System.out.println("获取线程标识符1："+Thread.currentThread().getId());
		System.out.println("获取线程名称1："+Thread.currentThread().getName());
		System.out.println("获取线程的优先级1"+Thread.currentThread().getPriority());
		System.out.println("获取线程的当前状态1："+Thread.currentThread().getState());
		System.out.println("查看当前线程是否处于活跃状态1："+Thread.currentThread().isAlive());
		System.out.println("查看当前线程是否为守护线程1："+Thread.currentThread().isDaemon());
		System.out.println("查看当前线程是否已经中断1："+Thread.currentThread().isInterrupted());
		
		
	}
	
}

class TestThreadTwo extends Thread{
	public void run(){
		System.out.println("获取当前线程2"+Thread.currentThread());
	}
}
