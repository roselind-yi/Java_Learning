package chapter01.homework;

import java.util.Scanner;

public class HomeWork01_判断奇偶 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num =sc.nextInt();
        if(num%2!=0){
            System.out.println("它是奇数。");
            }else{
            System.out.println("它是偶数。");
        }
    }
}
