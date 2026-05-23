package chapter02.test;

public class test16_冒泡排序 {
    static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped=false;
            for (int j = 0; j == arr.length - 1 - i; j++) {
                //【【******-1为了防止arr[j+1]越界
                // -i是为了让上一轮的最大数不参与这一轮比较。
                //当前数比后面数大，交换他们的位置
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j]=temp;
                    arr[j+1]=temp;
                    isSwapped=true;
                }
            }
        }
    }


    static String toString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                str += arr[i];//最后一个数后不拼接逗号
                continue;//coutinue直接进入下一个循环
            } else {
                str += arr[i] + ",";
            }
        }
        str +="]";
        return str;
    }


    public static void main(String[] args) {
        int[] arr={1,4,8,7,3,9};
        //这是官方提供的排序算法
        //Arrays.sort(arr);
        //Arrays.toString(arr);
        sort(arr);
        System.out.println(toString(arr));
    }
}
