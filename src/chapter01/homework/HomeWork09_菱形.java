package chapter01.homework;

import java.util.Scanner;

public class HomeWork09_菱形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请随便输入一个行数（奇数）：");
        int n = sc.nextInt();
        int mid = n / 2 + 1;

        for (int i = 1; i <= mid; i++) {
            for (int j = 1; j <= mid - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = mid - 1; i >= 1; i--) {
            for (int j = 1; j <= mid - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}