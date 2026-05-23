package chapter02.test;

public class test16_交换两个变量 {
    public static void main(String[] args) {
        //1.借助临时变量,中间变量（这会用到额外内存）
        int a=5;
        int b=9;

        //2.用二进制运算
        a=a^b;//亦或
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);

        /**
         * 5，9
         * 9，5
         * 5，9
         * 9，5
         */
    }
}
