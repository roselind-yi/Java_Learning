package chapter02.homework;

public class HomeWork01_数组元素求和 {
    public static void main(String[] args) {
    int arr[]={1,33,53,256,9};
    long sum=sum(arr);
        System.out.println("数组元素求和后的结果是："+sum);
    }

    private static long sum(int[] arr) {
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}

