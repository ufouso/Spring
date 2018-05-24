package com.xpp.test.mytest;

public class TestOne {
	
	public static void main(String[] args) {
		C c = new C();
		B b = new B();
//		(C)b
		System.out.println((A)b);
	}
}


class A{
	public void a(){
		System.out.println("a");
	}
}

class B extends A{
	public void b(){
		System.out.println("b");
	}
}

class C extends A{
	public void c(){
		System.out.println("c");
	}
}