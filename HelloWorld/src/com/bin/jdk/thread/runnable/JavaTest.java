package com.bin.jdk.thread.runnable;

class SaleTicket implements Runnable{  
    private int tickets = 100;  
      
      
    private synchronized void sale(){  
        if(tickets > 0){  
        	tickets--;
              
            try{  
                Thread.sleep(100);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
            System.out.println(Thread.currentThread().getName() + "卖出 第 "+ (tickets )+"张票");  
            
        }  
    }  
    public void run(){  
        while(tickets > 0){  
            sale();  
        }  
    }  
}  
  
  
public class JavaTest {  
          
    public static void main(String[] args){  
  
  
        SaleTicket st = new SaleTicket();  
        /* Thread t1 = new Thread(st, "一号窗口");  
        Thread t2 = new Thread(st, "二号窗口");  
        Thread t3 = new Thread(st, "三号窗口");  
        Thread t4 = new Thread(st,"四号窗口 ");  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  */
        
        for (int i = 0; i < 20; i++) {
        	Thread t1 = new Thread(st, i+"号窗口");  
        	t1.start();  
		}
        
          
      
          
    }  
}  