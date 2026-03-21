package chapter02.test;

public class test09_递归函数 {
    static int foo(int n){
    if(n==1) return 1;
    //自己调用自己，成为递归调用
    return n+foo(n-1);

    }
    public static void main(String[] args) {
        //递归函数

        //需求:1-100的累加之和
        //foo函数会入栈几次？
        System.out.println(foo(4));
    }
}
