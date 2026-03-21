package chapter01.homework;

import java.util.Scanner;

public class HomeWork03_判断哪年哪月有多少天 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份：");
        int year=sc.nextInt();
        System.out.println("请输入月份：");
        int month=sc.nextInt();
        int days=0;
        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days=31;
                break;
            case 4: case 6: case 9: case 11:
                days=30;
                break;
            case 2:
                if((year %400==0)||(year%4==0 && year%100!=0))
                {
                days=29;
                }else
                {
                days=28;
                }
                break;
            default:
                System.out.println("输入月份无效。");
        }
        System.out.println(year+"年"+month+"月"+"共计"+days+"天");
    }
}
