package com.bin.jdk.str.statics;

public class StringObjectEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		 
		
		StrAddress xx=new StrAddress();
		StrAddress y=new StrAddress();
		 
		System.out.println(xx.a== y.a); //true
		System.out.println(xx.b== y.b); //true
		System.out.println(xx.c== y.c); //false
		System.out.println(xx.d== y.d); //true
		
	}

}
class StrAddress{
	public static String a="alsdfjkasdf";
	public  String b="alsdfjkasdfasdfasdf";
	public String c=new  String("adfasdfd");
	public static String d=new  String("adfasdf");
	
}
