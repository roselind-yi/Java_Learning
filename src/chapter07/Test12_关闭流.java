package chapter07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test12_关闭流 {
    public static void main(String[] args) {
        // 1. 把变量is定义到try的外面 【提升变量的作用域】
        InputStream is = null;

        try {
            // 在try里面创建流
            is = new FileInputStream("D:/hello.txt");
            // 使用流

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 在finally中关闭流
            // 防止空指针异常,先对流进行判空
            if (is != null) {
                try {
                    is.close();
                    System.out.println("流关闭成功");
                } catch (IOException e) {
                    System.out.println("流关闭失败");
                }
            }
        }

    }
}