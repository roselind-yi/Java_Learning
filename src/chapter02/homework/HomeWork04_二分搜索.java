package chapter02.homework;

import java.util.Arrays;

public class HomeWork04_二分搜索 {
    public static void main(String[] args) {
        int[] arr = {1, 33, 53, 256, 9, 24, 6, 90};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = midsearch(arr, 9);
        if (index == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("存在，其索引为：" + index);
        }
    }

    static int midsearch(int[] arr, int target) {
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midvalue=arr[mid];
            if(midvalue>target){
                right=mid-1;
            }else if(midvalue<target){
                left=mid+1;
            }else{
                index=mid;
                break;
            }
        }
        return index;
    }
}