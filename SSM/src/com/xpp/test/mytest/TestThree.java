package com.xpp.test.mytest;

public class TestThree {
	
	public static void main(String[] args) {
		System.out.println("main:的线程"+Thread.currentThread());
		Thread1 t1= new Thread1();
		Thread t = new Thread(t1);
		t.start();
		System.out.println("运行线程的ID:"+t.getId()+",运行线程的Name:"+t.getName());
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		System.out.println("运行中的线程："+Thread.currentThread());
	}
	
}
