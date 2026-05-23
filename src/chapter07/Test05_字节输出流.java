package chapter07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test05_字节输出流 {
    public static void main(String[] args) {
        //OutputStream是字节输出流的父类
        //FileOutputStream是其子类,文件字节输出流

        //OutputStream os = new FileOutputStream("D：/hello.txt");
        //加了个参数，【true】追加写；【false】，附加写
        //OutputStream os = new FileOutputStream("D：/hello.txt",false);

        //追加写
        //OutputStream os = new FileOutputStream(file);
        //OutputStream os = new FileOutputStream(file,false);

        try {
            OutputStream os = new FileOutputStream("D:/hello.txt",true);
            System.out.println("输出流创建成功。");
            byte[] data={67,89,89,89,99};
            os.write(data);
            //不支持直接写入字符串
            String str="测试字节流输出。";
            os.write(str.getBytes());
            System.out.println("写入成功");
        } catch (FileNotFoundException e) {
            System.out.println("输出流创建失败...");
        } catch (IOException e) {
            System.out.println("写入失败...");
        }
    }
}
