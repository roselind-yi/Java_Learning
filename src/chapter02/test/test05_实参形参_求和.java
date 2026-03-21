package chapter02.test;

public class test05_实参形参_求和 {
    //形参用于定义参数类型，个数，名称，形参只是一个变量，可以指向任意数组
    static long sum(int[] arr){
        long sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        //实参，这里调用的sum(arr),sum(arr1)传递的arr和arr1成为实参，是在调用函数之前预定义好的数据。
        int[] arr={23,4,36,434,66,77,86,97,23,68};
        long sum=sum(arr);
        System.out.println("数组拼接之后相加得到的值："+sum);

        int[] arr1={223,34,436,34,6,7,56,67,23,9};
        long sum1=sum(arr1);
        System.out.println("数组拼接之后相加得到的值："+sum1);


    }

}
