package chapter01;

import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        //多路选择分支

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数:");
        double score = sc.nextDouble();
        // 在多路分支中, 难实现的条件放前面判断
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 70) {
            System.out.println("中等");
        } else if (score >= 60){
            System.out.println("及格");
        } else {//最后一路分支可以不写if只写else，用于分支兜底，表示以上都不成立再运行此条指令
            System.out.println("不及格");
        }
    }
}
