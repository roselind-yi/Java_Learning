package chapter02.test;

public class test07_最小值 {
    static int min(int[] arr){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr1={23,4,36,434,66,77,86,97,23,68};
        int min1=min(arr1);//此处在学习时不熟练，多加记忆！
        System.out.println("数组1的最小值是："+min1);

        int[] arr2={223,34,436,34,6,7,56};
        int min2=min(arr2);
        System.out.println("数组2的最小值是："+min2);
    }
}

