package chapter01;

public class Test14 {
    public static void main(String[] args) {
        //do while循环,可以保证循环至少执行一次
        int n =1;
        int sum=0;
        do{
            sum +=n;
            n++;
        }
        while(n<=100);
        System.out.println(sum);
    }
}
