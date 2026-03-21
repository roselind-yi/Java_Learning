package chapter02.test;

public class test06_最大值 {

    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1={23,4,36,434,66,77,86,97,23,68};
        int max1=max(arr1);//此处在学习时不熟练，多加记忆！
        System.out.println("数组1的最大值是："+max1);

        int[] arr2={223,34,436,34,6,7,56};
        int max2=max(arr2);
        System.out.println("数组2的最大值是："+max2);


    }
}
