package chapter02.test;

public class test08_链式调用 {
    public static void main(String[] args) {
        int a=10;
        System.out.println(faa(a));
    }
    static int faa(int x){
        int a=20;
        return fee(x)+a;
    }
    static int fee(int x){
        int a=30;
        return foo(x)+a;
    }
    static int foo(int x){
        int a=40;
        return x+a;
    }
}
