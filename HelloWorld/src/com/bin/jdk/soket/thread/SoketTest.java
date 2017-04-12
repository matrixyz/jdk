package com.bin.jdk.soket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;  



public class SoketTest {
    public static void main(String[] args) throws IOException {  
        ServerSocket server = new ServerSocket(5678);  
        Socket client = server.accept();  
        BufferedReader in = new BufferedReader(new InputStreamReader(  
                client.getInputStream()));  
        PrintWriter out = new PrintWriter(client.getOutputStream());  
        while (true) {  
            String str = in.readLine();  
            System.out.println(str);  
            out.println("has receive....");  
            out.flush();  
            if (str.equals("end"))  
                break;  
        }  
        client.close();  
        server.close();
    }
}
class MyClient {  
    static Socket server;  
  
    public static void main(String[] args) throws Exception {  
        server = new Socket(InetAddress.getLocalHost(), 5678);  
        BufferedReader in = new BufferedReader(new InputStreamReader(  
                server.getInputStream()));  
        PrintWriter out = new PrintWriter(server.getOutputStream());  
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));  
        while (true) {  
            String str = wt.readLine();  
            out.println(str);  
            out.flush();  
            if (str.equals("end")) {  
                break;  
            }  
            System.out.println(in.readLine());  
        }  
        server.close();  
    }  
}  
class MultiClient extends Thread {  
    private Socket client;  
  
    public MultiClient(Socket c) {  
        this.client = c;  
    }  
  
    public void run() {  
        try {  
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                    client.getInputStream()));  
            PrintWriter out = new PrintWriter(client.getOutputStream());  
            // Mutil User but can't parallel  
  
            while (true) {  
                String str = in.readLine();  
                System.out.println(str);  
                out.println("has receive....");  
                out.flush();  
                if (str.equals("end"))  
                    break;  
            }  
            client.close();  
        } catch (IOException ex) {  
        } finally {  
        }  
    }  
  
    public static void main(String[] args) throws IOException {  
        ServerSocket server = new ServerSocket(5678);  
        while (true) {  
            // transfer location change Single User or Multi User  
  
            MultiClient mc = new MultiClient(server.accept());  
            mc.start();  
        }  
    }  
}