package com.bin.jdk.thread.vectorsafe;

import java.util.*;
/*Vector的好处在于可以是线程安全的，像ArrayList，我们添加一个元素时，先要把下标加1，然后再赋值，
所以如果有多个线程同时向一个ArrayList里面添加东西时，由于不是线程安全的所以就有可能出错。
我们这时要用ArrayList的话，必须保证ArrayList的add操作必须是线程安全的，要放在synchronized 中，，，，*/
//实现Runnable接口的线程  
public class HelloThread implements Runnable {  
    String name;  
   // List<String> v;  
    Vector<String> v;  
  
    HelloThread(String name, Vector<String> v) {  
        this.name = name;  
        this.v = v;  
    }  
  
    public void run() {  
        System.out.println(name + "start");  
        while(true) {  
            v.add(name + ".add");  
            System.out.println(name + " list size is " + v.size());  
  
            try {  
                Thread.sleep(1000);  
            } catch(InterruptedException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
    }  
  
    public static void main(String args[]) throws InterruptedException {  
  
    	Vector<String> v = new Vector<String>();  
  
        HelloThread hello1 = new HelloThread("hello1", v);  
        HelloThread hello2 = new HelloThread("hello2", v);  
        HelloThread hello3 = new HelloThread("hello3", v);  
  
        Thread h1 = new Thread(hello1);  
        Thread h2 = new Thread(hello2);  
        Thread h3 = new Thread(hello3);  
        h1.start();  
        h2.start();  
        h3.start();  
  
    }  
}  