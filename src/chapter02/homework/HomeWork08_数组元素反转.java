package chapter02.homework;


public class HomeWork08_数组元素反转 {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        System.out.println("翻转前：");
        printArray(arr);
        reverseArray(arr);
        System.out.println("翻转后：");
        printArray(arr);

    }

    static void reverseArray(int[] arr){
        int left=0;
        int right =arr.length-1;
        while(left<right){
            arr[left]=arr[left]^arr[right];
            arr[right]=arr[left]^arr[right];
            arr[left]=arr[left]^arr[right];
            left++;
            right--;
        }
    }
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
}
