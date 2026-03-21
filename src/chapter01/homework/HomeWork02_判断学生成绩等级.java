package chapter01.homework;

import java.util.Scanner;

public class HomeWork02_判断学生成绩等级 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个学生的成绩（0-100）：");
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 70) {
            System.out.println("中等");
        } else if (score >= 60) {
            System.out.println("及格");
        } else if (score >= 0) {
            System.out.println("不及格");
        } else {
            System.out.println("输入无效。");
        }
    }
}
