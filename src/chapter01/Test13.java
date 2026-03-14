package chapter01;

public class Test13 {
    public static void main(String[] args) {
        //for循环时while循环的简化版本
        int sum=0;
        for (int n=1;n<=100;n++)//for(要点1；要点2；要点4){要点4}
        {
            sum+=n;
        }
        System.out.println(sum);
    }
}
