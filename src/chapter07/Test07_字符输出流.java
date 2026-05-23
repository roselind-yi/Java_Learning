package chapter07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test07_字符输出流 {
    public static void main(String[] args) {
        // 字符输出流: 以字符为单位进行输出
        // Writer是字符输出流的父类
        // FileWriter是字符输出流的子类
        // Writer w = new FileWriter("D:/hello.txt");
        // Writer w = new FileWriter("D:/hello.txt", true);
        // File file = new File("D:/hello.txt");
        // Writer w = new FileWriter(file);
        // Writer w = new FileWriter(file, true);

        try {
            Writer w = new FileWriter("D:/hello.txt", true);
            System.out.println("输出流创建成功!");
            // 一次写入一个字符
            w.write('通');
            // 一次写入一个字符数组
            char[] data = {'通', '达', '学', '院'};
            w.write(data);
            // 字符流可以直接写入字符串, 不需要转换, 字符串的本质就是字符数组
            String str = "测试写入字符串";
            w.write(str);
            // 字符流的底层是基于字节流, 内部维护一个8KB的缓冲区, 用于减少刷盘的次数和频率
            // 缓冲区写满后, 会自动触发刷入磁盘, 然后清空缓冲区
            // 如果缓冲区没有写满, 需要手动调用flush进行冲刷1
            w.flush(); // 手动调用一次刷盘函数
            System.out.println("写入成功!");
        } catch (IOException e) {
            System.out.println("输出流创建失败!");
        }
    }
}