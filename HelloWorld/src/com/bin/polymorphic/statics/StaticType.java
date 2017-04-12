package com.bin.polymorphic.statics;

public class StaticType {
	public void sayHello(){
		System.out.println("StaticType.sayHello");
	}
	public void sayHello(String args){
		System.out.println("StaticType.sayHello");
	}
	public void sayHello(StaticType args){
		System.out.println("StaticType.sayHello");
	}
	
	public static void main(String[] args) {
		
		StaticType cur=new DynamicExtendsType();
		  cur=new DynamicExtendsTypea();
		
		 
		
		cur.sayHello("hello");
		cur.sayHello(new DynamicExtendsType());
		
	}
	
}
class DynamicExtendsType extends StaticType{
	public void sayHello(String args){
		System.out.println("dynamicExtendsType.sayHello");
	}
	 
}
class DynamicExtendsTypea extends StaticType{
	public void sayHello(String args){
		System.out.println("dynamicExtendsType.sayHello");
	}
	 
}
 
