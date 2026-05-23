package chapter07;

import java.io.*;

public class Test09_分词 {
    public static void main(String[] args) {
        // 增强型的字符输入流:以普通字符流为基础进行功能增强【支持一次读一行】
        try {
            // 创建普通的字符输入流
            Reader r = new FileReader("D:/hello.txt");
            // 创建增强型的字符输入流, 构造函数中用普通的流作为参数
            BufferedReader br = new BufferedReader(r);
            // br.readLine()支持一次读一行
            String line = null; // 定义变量line接收每一行字符串
            // 将读取到的一行字符串赋给line，并判断line是否等于null，决定循环是否继续
            while ((line = br.readLine()) != null) {
                // 将一行字符串进行分词, 可以调用字符串的分词函数split()
                // 指定以空格作为分隔符, 返回单词数组
                String[] words = line.split(" ");
                // 遍历单词数组, 打印每个单词
                for (String word : words) {
                    System.out.println(word);
                }
                System.out.println("-------------------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("流创建失败");
        } catch (IOException e) {
            System.out.println("读取数据失败");
        }
    }
}