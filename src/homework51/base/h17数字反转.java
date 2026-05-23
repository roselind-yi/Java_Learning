package homework51.base;

import java.util.Scanner;

public class h17数字反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();

        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println("反转后的数字：" + reversed);
        scanner.close();
    }
}
