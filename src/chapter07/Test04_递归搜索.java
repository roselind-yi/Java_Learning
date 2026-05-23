package chapter07;

import java.io.File;

public class Test04_递归搜索 {
    public static void main(String[] args) {
        //创建一个起始目录
        File file=new File("D:/iweb");
        search(file,".docx");
    }

    static void search(File file, String type) {

        if(file.isFile()){
            //如果file是一个文件，递归搜索
            String fileName= file.getName();
            //endsWith
            //startsWith
            //contains
            if (fileName.endsWith(type)) {
                System.out.println(file.getAbsolutePath());
            }
            return;
        }

        //如果file是一个文件夹，开始递归搜索
        if(file.isDirectory()){
            File[] files =file.listFiles();
            //判断是否为空文件夹，停止递归
        if(files == null || files.length == 0){
            return;
        }
        //遍历files数组
            for (File f : files) {
               //递归，把当前子文件f和文件类型type传给下一个search函数
                search(f,type);
            }
        }
    }
}
