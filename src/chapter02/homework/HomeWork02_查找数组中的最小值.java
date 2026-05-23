package chapter02.homework;

public class HomeWork02_查找数组中的最小值 {
    public static void main(String[] args) {
        int[] arr={1,33,53,256,9};
        int min=min(arr);
        System.out.println("查找到了数组中的最小值为："+min);
    }
    static int min(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

}
