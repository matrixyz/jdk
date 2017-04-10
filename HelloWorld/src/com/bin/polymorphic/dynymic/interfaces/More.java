package com.bin.polymorphic.dynymic.interfaces;

 interface Mores {
	public void test();

}

class TestImplA implements Mores{

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("TestImplA.test()");
	}
	
}
class TestImplB implements Mores{

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("TestImplA.test()");
	}
	
}
public class More{
	public static void main(String[] args) {
		Mores more=null;
		//*********
		more.test();
		
		
	}
}