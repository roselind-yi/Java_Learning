package homework51.base;

import java.util.Scanner;

public class h4求三个数的最大值 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int a= scanner.nextInt();
        System.out.println("请输入第二个整数：");
        int b= scanner.nextInt();
        System.out.println("请输入第三个整数：");
        int c= scanner.nextInt();

        int max=Math.max(a,Math.max(b,c));

        System.out.println("最大值是："+max);

    }
}
