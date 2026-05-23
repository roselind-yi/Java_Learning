package chapter02.homework;


public class HomeWork10_递归计算数组元素的最大值 {
    public static void main(String[] args) {
        int[] arr = {1, 33, 53, 256, 9, 24, 6, 90};
        int max = findMax(arr, 0);
        System.out.println("数组中最大值是：" + max);
    }
    static int findMax(int[] arr,int index){
        if(index==arr.length-1){
            return arr[index];
        }
        int current=arr[index];
        int maxOfRest=findMax(arr,index+1);
        return Math.max(current,maxOfRest);
    }
}
