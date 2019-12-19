package com.workSocket;
import com.workSocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketThreak extends Thread{
    @Override
    public void run() {
        int clidnPort = 8888;
        try {
            ServerSocket serverSocket= new ServerSocket(clidnPort);
            Socket socket = serverSocket.accept();
            String str = null;
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
            InputStreamReader isr2=new InputStreamReader(System.in);
            BufferedReader br2=new BufferedReader(isr2);

            while(true){
                String infoFromClient=br.readLine();
                System.out.println("客户端："+infoFromClient);
                if(infoFromClient.equals("bye")){
                    socket.close();
                    break;
                }
                System.out.println("请输入:");
                String re=br2.readLine();
                pw.println(re);
            }

        } catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
