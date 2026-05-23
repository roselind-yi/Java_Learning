package homework51.base;

import java.util.Scanner;

public class h13判断是否为三角形 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入第一条边：");
        double a=scanner.nextDouble();
        System.out.println("请输入第二条边：");
        double b=scanner.nextDouble();
        System.out.println("请输入第三条边：");
        double c=scanner.nextDouble();

        boolean isTriangle = a+b>c && b+c>a&&a+c>b;

        if(isTriangle){
            System.out.println("这三条边可以构成三角形。");
        }else{
            System.out.println("这三条边不能构成三角形。");
        }
        scanner.close();

    }

}
