package homework51.base;

import java.util.Scanner;

public class h15求阶乘 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long result=1;
                for(int i=1;i<=n;i++){
                    result*=i;
                }
        System.out.println(n+"！="+result);
                scanner.close();
    }

}
