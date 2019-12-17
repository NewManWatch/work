package com.workSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
      @autor NewManWatch
	  @Time 2019-12-17 22:14:35
	  @param work：socket半双工通讯客户端

     */
public class SocketKHD {
    public static void main(String[] args) throws IOException {
        int clidnPort = 4574;
        try {
            Socket socket = new Socket("127.0.0.1",clidnPort);
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(isr);
            InputStreamReader isr2=new InputStreamReader(socket.getInputStream());
            BufferedReader br2=new BufferedReader(isr2);
            while(true){
                System.out.println("请输入:");
                String info=br.readLine();
                pw.println(info);
                if(info.equals("bye")){
                    System.out.println("通话结束！");
                    socket.close();
                    break;
                }
                //接受从服务器发来的信息
                String res=br2.readLine();
                System.out.println("服务器端："+res);
            }
/*
            该Socket部分参考CSDN博主「passtheworld」的原创文章，
            原文链接：https://blog.csdn.net/qq_25134469/article/details/51420532
*/
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (ConnectException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
