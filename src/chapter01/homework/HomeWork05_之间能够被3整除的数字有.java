package chapter01.homework;

import java.util.Scanner;

public class HomeWork05_之间能够被3整除的数字有 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入start数字：");
        int start = sc.nextInt();
        System.out.println("请输入end数字：");
        int end = sc.nextInt();
        System.out.println(start + "到" + end + "之间所有能够被3整除的数字有：");
        for (int i = end; i > start; i--) {
            if (i % 3 == 0) {
                System.out.println(i + ",");
            }
        }
    }
}