package chapter01.test;

import java.util.Scanner;

public class Test11_条件分支 {
    public static void main(String[] args) {
        //switch case条件分支（多路）
        //switch括号里面是变量，只支持等值条件，后跟break，且不再向后运行。最后写个default表示都不行时执行的命令。
        // if里面是条件，支持区间条件。
        double money;
        int year;
        double rate;
        double total;

        //导入和创建Scanner
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入本金：");
        money = sc.nextDouble();
        System.out.println("请输入年限：");
        year = sc.nextInt();
        switch (year){
            case 1://year=1的分支
                rate=0.015;
                break;//跳出switch
            case 2:
                rate=0.016;
                break;
            case 3:
                rate=0.017;
                break;
            case 4:
                rate=0.018;
                break;
            case 5:
                rate=0.02;
                break;
            default:
                rate=0;
        }
        //
        total=money * (1 + year*rate);
        System.out.println(year+ "年后，可得本金+利息共计："+ total);
    }

}
