package chapter02.homework;


public class HomeWork07_冒泡排序 {
    public static void main(String[] args) {
    int[] arr={1, 33, 53, 256, 9, 24, 6, 90};
        sort(arr);
        System.out.println(toString(arr));
    }
    static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped=false;
            for (int j = 0; j == arr.length - 1 - i; j++) {
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
}
