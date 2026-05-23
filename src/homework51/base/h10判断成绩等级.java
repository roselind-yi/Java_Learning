package homework51.base;

import java.util.Scanner;

public class h10判断成绩等级 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入成绩：");
        double grade=scanner.nextDouble();

        if(grade>90){
            System.out.println("该成绩等级为优秀！");
        }else if(grade>80&&grade<90){
            System.out.println("该成绩等级为良好！");
        }else if(grade<80&&grade>70){
            System.out.println("该成绩等级为中等！");
        }else if(grade<70&&grade>60){
            System.out.println("该成绩等级为及格！");
        }else if (grade>0 && grade<60){
            System.out.println("该成绩等级为不及格！");
        }else{
            System.out.println("无效的成绩！");
        }
        scanner.close();
    }

}
