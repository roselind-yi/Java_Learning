package homework51.base;

import java.util.Scanner;

public class h18计算等差数列和 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入首项：");
        int a1 = scanner.nextInt();
        System.out.print("请输入公差：");
        int d = scanner.nextInt();
        System.out.print("请输入项数：");
        int n = scanner.nextInt();

        int an = a1 + (n - 1) * d;
        int sum = n * (a1 + an) / 2;
        System.out.println("等差数列的和：" + sum);

        scanner.close();
    }
}
