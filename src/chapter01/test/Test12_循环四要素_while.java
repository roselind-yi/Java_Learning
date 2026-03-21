package chapter01.test;

public class Test12_循环四要素_while {
    public static void main(String[] args) {
        //循环四要素：
        // 循环的起点，初始化一个循环变量
        // 循环的终点，循环条件
        // 循环的步长，循环变量的迭代
        // 循环体，循环中要做的事情

        int n=1;
        int sum=0;
        while (n<=100){
            sum += n;
            n++;//循环的步长
        }
        System.out.println("累加之和："+ sum);
    }
}
