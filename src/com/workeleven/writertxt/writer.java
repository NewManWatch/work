package com.workeleven.writertxt;

import java.io.*;
/*
      @autor NewManWatch
	  @Time 2019年12月17日18:40:18
	  @param work：第十一章 - 实验编程02

     */
public class writer {
    public static void writertxt(String path,String writerfilename,String mode,String towriter){//path相对路径，writerfilename文件名称，mode操作方式w：覆盖 +w：文件尾部追加，towriter 写入内容
        if (mode.equals("w")){
            try{
// 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
                /* 写入Txt文件 */
                File writename = new File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
                if(!writename.exists()){
                    writename.mkdirs();
                }
                writename = new File(path + writerfilename+".txt");// 相对路径，如果没有则要建立一个新的output。txt文件
                writename.createNewFile(); // 创建新文件
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));
                out.write(towriter); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
                out.close(); // 最后记得关闭文件

            } catch (Exception e) {
                e.printStackTrace();
            }
            /*
             * 版权声明：
             *该分支参考了 CSDN博主「persistenceヾ(◍°∇°◍)ﾉ」的文章遵循 CC 4.0 BY-SA 版权协议链接地址：https://blog.csdn.net/persistencegoing/article/details/88640737
             */

        }else if (mode.equals("+w")){

            try{
                File writename = new File(path);
                if(!writename.exists()){
                    writename.mkdirs();
                }
                writename = new File(path + writerfilename+".txt");
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(writename,true)));
                out.write(towriter+"\r\n");
                out.close();
/*
             * 版权声明：
             *该分支参考了CSDN博主「向阳争渡」的文章原文链接：https://blog.csdn.net/yangyang_yangqi/article/details/78931622
*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        writertxt("C:\\Users\\言\\Desktop\\java 作业\\work\\src\\com\\workeleven\\writertxt","sds","w","this is buildtxt to writer");
        writertxt("C:\\Users\\言\\Desktop\\java 作业\\work\\src\\com\\workeleven\\writertxt","sds","+w","this is text writer in end");
    }

}
