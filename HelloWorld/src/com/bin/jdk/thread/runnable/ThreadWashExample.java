package com.bin.jdk.thread.runnable;

class Wash implements Runnable{  
    private String bathroomDoorStates = "";  
    private String washManStates = "";  
     
      
    private    void washs() throws InterruptedException{  
    	String tnam=Thread.currentThread().getName();
    	bathroomDoorStates = "洗澡间门是打开的";
    	Thread.sleep(200);
    	bathroomDoorStates = "洗澡间门是关闭的";
    	Thread.sleep(300);
    	washManStates = "脱光了衣服";
    	
    	System.out.println(tnam+"在洗澡间"+bathroomDoorStates+washManStates);
    	 
    	
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
    	
        /* Thread t1 = new Thread(st, "一号窗口");  
        Thread t2 = new Thread(st, "二号窗口");  
        Thread t3 = new Thread(st, "三号窗口");  
        Thread t4 = new Thread(st,"四号窗口 ");  
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