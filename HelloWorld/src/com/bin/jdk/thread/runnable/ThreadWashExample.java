package com.bin.jdk.thread.runnable;

class Wash implements Runnable{  
    private String bathroomDoorStates = "";  
    private String washManStates = "";  
     
      
    private    void washs() throws InterruptedException{  
    	String tnam=Thread.currentThread().getName();
    	bathroomDoorStates = "ϴ������Ǵ򿪵�";
    	Thread.sleep(200);
    	bathroomDoorStates = "ϴ������ǹرյ�";
    	Thread.sleep(300);
    	washManStates = "�ѹ����·�";
    	
    	System.out.println(tnam+"��ϴ���"+bathroomDoorStates+washManStates);
    	 
    	
    }  
    public void run(){  
        for (int i = 0; i <2; i++) {
        	try {
				washs();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }  
}  
  
  
public class ThreadWashExample {  
          
    public static void main(String[] args){  
  
    	Wash st = new Wash();
    	
        /* Thread t1 = new Thread(st, "һ�Ŵ���");  
        Thread t2 = new Thread(st, "���Ŵ���");  
        Thread t3 = new Thread(st, "���Ŵ���");  
        Thread t4 = new Thread(st,"�ĺŴ��� ");  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  */
        
        for (int i = 0; i < 50; i++) {
        	  
        	 
        	Thread t1 = new Thread(st,  ""+i);  
        	t1.start();  
		}
        
          
      
          
    }  
}  