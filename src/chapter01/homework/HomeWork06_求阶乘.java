package chapter01.homework;

import java.util.Scanner;

public class HomeWork06_求阶乘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = sc.nextInt();


        if (n < 0) {
            System.out.println("错误：阶乘只对非负整数定义！");
            sc.close();
            return;
        }

        long factorial = 1;//这里不太会该数学函数，查看了答案。

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println(n + "的阶乘是：" + factorial);
        sc.close();
    }
}
