package chapter07;

import java.io.File;
import java.io.IOException;

public class Test01_判断文件是否存在 {
    public static void main(String[] args) {
        String path="D:\\abc\\hello.txt";
        //前一个文件夹不存在。则后面try-catch会进入catch中输出创建失败
        File file=new File(path);
        if (file.exists()) {//非静态方法，无static修饰，要通过对象调用
            System.out.println("文件已存在。");
        }else{
            System.out.println("文件不存在。");
            try {
                //获取此文件的父目录
                File parentfile = file.getParentFile();
                if(!parentfile.exists()){
                    parentfile.mkdirs();
                }
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                //如果try中的代码出现了异常。则会进入catch中运行
                System.out.println("文件创建失败<*_*>");
            }
        }


    }
}
