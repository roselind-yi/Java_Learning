package chapter02.homework;


public class HomeWork06_斐波那契数列 {
    public static void main(String[] args) {
        int n=20;
        long result=fibonacci(n);
        System.out.println("斐波那契数列的第"+n+"项是："+result);
        }
        static long fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
        }
    }
