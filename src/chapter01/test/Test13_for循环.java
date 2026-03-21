package chapter01.test;

public class Test13_for循环 {
    public static void main(String[] args) {
        //for循环是while循环的简化版本
        int sum=0;
        for (int n=1;n<=100;n++)//for(要点1；要点2；要点4){要点4}
        {
            sum+=n;
        }
        System.out.println(sum);
    }
}
