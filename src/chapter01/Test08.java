package chapter01;

import java.util.Scanner;

public class Test08 {

    public static void main(String[] args) {

        // 选择分支 if - else
        Scanner sc = new Scanner(System.in);
        // 接收控制台输入一个四位整数, 判断是否为闰年
        System.out.println("请输入年份:");
        int year = sc.nextInt();
        if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
            System.out.println("是闰年");
        }else {
            System.out.println("不是闰年");
        }
    }
}
