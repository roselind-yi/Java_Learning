package chapter01;


import java.util.Scanner;

public class Test07 {
    public static void main(String[] args) {
        //左边的scanner是工具的模板文件名，需要导入工具包
        //右边的scanner是用模板创建的工具名，自定义
        //右侧是创建工具的固定写法
        Scanner sc = new Scanner(System.in);
        System.out.println("plz put in your name:");
        String name = sc.next();//【next是接收字符串输入】此命令左右两侧含义：接收到程序中 = 提供控制台输入

        System.out.println("plz put in your age:");
        int age = sc.nextInt();//【nextInt是接收整数输入】

        System.out.println("plz put in your height:");
        double height = sc.nextDouble();//【nextDouble是接收double输入】

        System.out.println("ok,i get it,now let me help u make a deal...");
        //System.out.println("姓名"+name);

    }

}
