package homework51.base;

import java.util.Scanner;

public class h16打印倒三角形 {
    public static void main(String[] args) {
        System.out.println("请随便输入个三角形的高度（正整数），我们一起打印一个倒的直角三角形。");
        Scanner scanner=new Scanner(System.in);
        int height=scanner.nextInt();
        for(int i=height;i>=1;i--){
            for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
        }
        scanner.close();
    }
}
