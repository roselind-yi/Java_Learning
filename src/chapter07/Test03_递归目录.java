package chapter07;

import java.io.File;

public class Test03_递归目录 {
    public static void main(String[] args) {
    //递归一个目录
        listDir("D:\\lihida");
        listDir("D:\\hello.txt");
        listDir("D:\\iweb");
    }
    /*
    * 查看目录中的文件列表
    * path
    * */
    static void listDir(String path){
       File dir =new File(path);
       //判断dir是否存在；dir是不是目录
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("不是一个目录");
            return;
        }
        File[] listFiles = dir.listFiles();
        // 遍历子文件数组listFiles
        for (File file : listFiles) {
            if (file.isFile()) {
                System.out.print("文件\t");
            }
            if (file.isDirectory()) {
                System.out.print("目录\t");
            }
            // 打印文件名
            System.out.println(file.getName());
        }
    }
}
