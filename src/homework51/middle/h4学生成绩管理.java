package homework51.middle;

import java.util.Scanner;

class Student{
    private String name;
    private  int score;

    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
}

public class h4学生成绩管理 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student[] students=new Student[3];

        for(int i=0;i<3;i++){
            System.out.println("请输入第"+(i+1)+"个学生姓名：");
            String name=scanner.next();

            System.out.println("请输入第"+(i+1)+"个学生成绩：");
            int score=scanner.nextInt();

            students[i]=new Student(name,score);
        }
        System.out.println("\n学生列表：");
        for(Student student : students){
            System.out.println("姓名："+student.getName()+"，成绩："+student.getScore());
        }
        scanner.close();
    }
}
