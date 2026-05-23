package chapter07;

import java.io.File;

public class Test02_循环调用 {
    public static void main(String[] args) {
        File[] roots=File.listRoots();//静态函数，可以直接用类名调用
        //写一个循环遍历roots数组
        //快捷键（roots.length.fori+回车）
        for (int i = 0; i < roots.length; i++) {
            System.out.println(roots[i].getAbsolutePath());
        }
        //增强型for循环。快捷键(roots.for)
        //for(数据类型 临时变量：数组体)
        //每循环一次自动取出数组中的一个对象，赋给临时变量，直到数组元素全部取完
        for (File root : roots) {
            System.out.println(root.getAbsolutePath());
        }
    }
}
