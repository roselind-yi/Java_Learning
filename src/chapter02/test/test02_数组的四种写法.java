package chapter02.test;

public class test02_数组的四种写法 {
    public static void main(String[] args) {
        //1.
        int arr[];//声明
        arr=new int[5];//分配内存
        arr[0]=10;//赋值

        //2.左边[]不写长度，右边[]必须写长度；
        int[] arr2=new int[5];//声明与分配空间合成一步；
        arr2[0]=10;

        //3.
        //声明，分配内存，赋值三部合成一行代码。
        //左边[]和右边[]都不写长度
        //编译时会自动根据{}中的元素个数识别应该分配多大空间
        int[] arr3=new int[]{10,20,30,40,50};

        //4.
        //三部合为一行,简化版本
        //右边直接用{}，分配空间和赋值
        int[] arr4= {10,20,30,40,50};
    }
}
