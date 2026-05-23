package homework51.middle;

import java.util.Scanner;

public class h3斐波拉契数列 {
    public static void main(String[] args) {
        System.out.print("请输入数列长度：");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.print("斐波拉契数列"+num+"项：");
        if(num>=1) System.out.print(1);
        if(num>=2) System.out.print("1");

        int a=1,b=1;
        for(int i=3;i<=num;i++){
            int c=a+b;
            System.out.print(" "+c);
            a=b;
            b=c;
        }
        scanner.close();
    }
}
