package com.bin.jdk.thread.vectorsafe;

import java.util.*;

//ʵ��Runnable�ӿڵ��߳�  
public class HelloThread implements Runnable {  
    String name;  
    List<String> v;  
  
    HelloThread(String name, List<String> v) {  
        this.name = name;  
        this.v = v;  
    }  
  
    public void run() {  
        System.out.println(name + "start");  
        while(true) {  
            v.add(name + ".add");  
            System.out.println(name + " list size is " + v.size());  
  
            try {  
                Thread.sleep(10);  
            } catch(InterruptedException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
    }  
  
    public static void main(String args[]) throws InterruptedException {  
  
        List<String> v = new ArrayList<String>();  
  
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