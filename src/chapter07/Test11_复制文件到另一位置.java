package chapter07;

import java.io.*;

public class Test11_复制文件到另一位置 {
    public static void main(String[] args) {
        // 文件复制的原理:
        // 字节流可以复制任何文件
        // 字符流只能复制文本文件
        // 输入流 -> 读取源文件
        // 输出流 -> 写入到目标文件
        // 循环读写, 完成复制的过程

        // 源文件的路径必须存在
    String from="E:\\壁纸\\1328225.png";
    String to="D:\\abc\\copy.png";

        try {
            // 创建字节输入流, 用于读取源文件
            InputStream is = new FileInputStream(from);
            // 创建字节输出流, 用于输出到目标文件
            OutputStream os = new FileOutputStream(to);
            // 创建一个内存的中转站, 即字节缓冲数组
            // 缓冲区决定了IO的次数
            // 缓冲区越大, IO次数就越少, 速度越快
            // 缓冲区越小, IO次数就越高, 速度越慢
            // 建议缓冲区开在64KB-256KB之间
            byte[] data = new byte[1024 * 128];
            int len = -1;
            // 记录系统此刻的时间戳
            long start = System.currentTimeMillis();
            // 循环读取源文件, 存储到内存的缓冲区中
            while ((len = is.read(data)) != -1) {
                // 将缓冲区写入到目标文件
                os.write(data, 0, len);
            }
            System.out.println("复制成功!");
            // 记录系统此刻的时间戳
            long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start) + "毫秒");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}