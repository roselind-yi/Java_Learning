package chapter07;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Test10_一次输入一行的字符输入流 {
    public static void main(String[] args) {
        // 增强型的字符输出流: 以字符流为基础进行增强,一次写入一行,自动换行
        try {
            // 创建普通字符输出流
            Writer w = new FileWriter("D:/hello.txt");
            // 创建增强型字符输出流
            BufferedWriter bw = new BufferedWriter(w);

            // 控制台输入扫描
            Scanner s = new Scanner(System.in);
            while (true) {
                System.out.println("请输入内容（exit退出）:");
                // 读取控制台的一行输入
                String line = s.nextLine();
                // equalsIgnoreCase忽略大小写的字符串比较
                if ("exit".equalsIgnoreCase(line)) {
                    // 跳出循环
                    break;
                }
                // 一次写入一行字符串
                bw.write(line);
                // 写入一个换行符
                bw.newLine();
                // 冲刷一下输出流的缓冲区
                bw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}