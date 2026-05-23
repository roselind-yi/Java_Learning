package chapter02.homework;

import java.util.Scanner;

public class HomeWork05_递归计算阶乘 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("输入一个整数：");
    int n = sc.nextInt();
    long result=factorial(n);
        System.out.println("递归计算阶乘后的结果是："+result);

    }

    static long factorial(int n) {
        if(n==0||n==1){
            return 1;
        }
    return n*factorial(n-1);
    }
}

