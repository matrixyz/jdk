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
            System.out.println(Thread.currentThread().getName() + "���� �� "+ (tickets )+"��Ʊ");  
            
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
        /* Thread t1 = new Thread(st, "һ�Ŵ���");  
        Thread t2 = new Thread(st, "���Ŵ���");  
        Thread t3 = new Thread(st, "���Ŵ���");  
        Thread t4 = new Thread(st,"�ĺŴ��� ");  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  */
        
        for (int i = 0; i < 20; i++) {
        	Thread t1 = new Thread(st, i+"�Ŵ���");  
        	t1.start();  
		}
        
          
      
          
    }  
}  