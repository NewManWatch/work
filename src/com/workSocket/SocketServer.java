package com.workSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
/*    @autor NewManWatch
	  @Time 2019-12-17 22:14:35
	  @param work：socket半双工通讯服务器
     */
public class SocketServer {
    public static void main(String[] args) throws IOException {
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
     /* 该Socket部分参考CSDN博主「passtheworld」的原创文章，*/
     /*  原文链接：https://blog.csdn.net/qq_25134469/article/details/51420532*/
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
