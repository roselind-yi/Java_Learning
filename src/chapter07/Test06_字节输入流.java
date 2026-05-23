package chapter07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test06_字节输入流 {
    //以字节为单位，读取外部设备中的数据到内存
    //只有一种，与输出流不同


    public static void main(String[] args) {
        try {
            InputStream is=new FileInputStream("D:/hello.txt");
            System.out.println("输入流创建成功。");

            //int data;

            //while((data=is.read()) != -1){
                //System.out.println(data);//(char)data转换不合适，转换出乱码了


            //一次读一个字节数组
            byte[] data=new byte[8];
            int len=-1;
            //例如文件总大小为20个字节，第一次读1-8个字节放到缓冲区，返回8
            //第一次读9-16个字节放到缓冲区，返回8
            //第一次读17-20个字节放到缓冲区，返回4
            //第四次没有字节可读，返回len。
            while((len=is.read(data))!=-1){
                //在循环中，把字节数组缓冲区重新编码为字符串
                //不能编码缓冲区里面的所有字节，应该从len编码到len,防止最后一轮重复编码。
                String s =new String(data,0,len);
                //将编码后的字符串打印出来
                System.out.print(s);
            }

            //}

        } catch (FileNotFoundException e) {
            System.out.println("输出流创建失败。");
        } catch (IOException e) {
            System.out.println("读取失败");
        }
    }
    }

