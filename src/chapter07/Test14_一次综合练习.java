package chapter07;

import java.io.*;

public class Test14_一次综合练习 {
    public static void main(String[] args) {
        String from = "E:\\壁纸\\1328225.png";
        String to = "D:\\abc\\copy.png";
    }

    static void copy (String from, String to) {
        // 用老式语法实现 try-catch-finally
        // 手动关闭流
        // 注意1: 提升流的变量作用域，使其可以对finally可见
        // 注意2: 先开后关

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);

            // 使用流
            byte[] data = new byte[1024 * 128];
            int len = -1;
            while ((len = is.read(data)) != -1) {
                os.write(data);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static void copy2 (String from, String to) {
        // 用新式语法
        // 自动关闭流
        try (
                // 创建流 -> 使用完自动关闭
                InputStream is = new FileInputStream(from);
                OutputStream os = new FileOutputStream(to);
        ){
            // 使用流
            byte[] data = new byte[1024 * 128];
            int len = -1;
            while ((len = is.read(data)) != -1) {
                os.write(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


