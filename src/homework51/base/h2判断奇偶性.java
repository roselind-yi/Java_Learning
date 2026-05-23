package homework51.base;

import java.util.Scanner;

public class h2判断奇偶性 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println((num + "是偶数"));
        } else {
            System.out.println((num + "是奇数"));
        }
    }
}

