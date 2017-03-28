package com.bin.jdk.thread.runnable;

class SaleTicket implements Runnable{  
    private int tickets = 100;  
      
      
    private synchronized void sale(){  
        if(tickets > 0){  
            System.out.println(Thread.currentThread().getName() + "���� �� "+ (tickets--)+"��Ʊ");  
              
            try{  
                Thread.sleep(500);  
            }catch(InterruptedException e){  
                e.printStackTrace();  
            }  
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
        Thread t1 = new Thread(st, "һ�Ŵ���");  
        Thread t2 = new Thread(st, "���Ŵ���");  
        Thread t3 = new Thread(st, "���Ŵ���");  
        Thread t4 = new Thread(st,"�ĺŴ��� ");  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
          
      
          
    }  
}  