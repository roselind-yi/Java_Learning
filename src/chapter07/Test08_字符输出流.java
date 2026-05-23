package chapter07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test08_字符输出流 {
    public static void main(String[] args) {
        // 字符输入流: 以字符为单位读取文本文件【不会把字符读破】
        // Reader是字符输入流的父类
        // FileReader是字符输入流的子类
        try {
            Reader r = new FileReader("D:/hello.txt");
            System.out.println("输入流创建成功!");
            // 一次读一个字符
//            int data;
//            while ((data = r.read()) !=-1) {
//                System.out.print((char) data);
//            }
            // 自己创建一个字符数组作为读的缓冲区
            char[] data = new char[10];
            int len; // 记录读取的字符长度
            while ((len = r.read(data)) != -1) {
                String s = new String(data,0, len);
                System.out.print(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("输入流创建失败!");
        } catch (IOException e) {
            System.out.println("读取数据失败!");
        }
    }
}