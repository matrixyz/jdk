package com.bin.jdk.thread.vectorsafe;

import java.util.*;
/*Vector�ĺô����ڿ������̰߳�ȫ�ģ���ArrayList���������һ��Ԫ��ʱ����Ҫ���±��1��Ȼ���ٸ�ֵ��
��������ж���߳�ͬʱ��һ��ArrayList������Ӷ���ʱ�����ڲ����̰߳�ȫ�����Ծ��п��ܳ���
������ʱҪ��ArrayList�Ļ������뱣֤ArrayList��add�����������̰߳�ȫ�ģ�Ҫ����synchronized �У�������*/
//ʵ��Runnable�ӿڵ��߳�  
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