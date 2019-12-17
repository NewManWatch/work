package com.workeleven.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class ridetxt {

    public static String Ridetxt(File ridefilename){

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(ridefilename));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args){
        File file = new File("C:\\Users\\言\\Desktop\\java 作业\\work\\src\\com\\workeleven\\toride"+".txt");
        System.out.println(Ridetxt(file));
    }


}

