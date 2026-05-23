package chapter02.test;

import java.util.Arrays;

public class test12_二分搜索 {
    static int binarySearch(int[] arr,int target){
    int index=-1;
    //低位索引（左侧索引）
    int left =0;
    //高位索引（右侧索引）
    int right=arr.length-1;

    //循环二分
        while(left<=right){
            //中位索引
            int mid=left+(right - left)/2;
            //取出中位值
            int midValue=arr[mid];
            //用中位值与目标值进行比较：大，等于，小
            if(midValue>target){
                right =mid-1;
            }else if(midValue<target){
                left=mid+1;
            }else{
                index=mid;
                break;
            }
        }
    return index;
    }
    public static void main(String[] args) {
        //无序的集合不能进行二分搜索
        int[] arr={23,4,36,434,66,77,86,97,23,68};
        //Arrays官方提供的数组工具
        //sort是排序函数
        Arrays.sort(arr);
        //string函数用于将数字转换为字符串
        System.out.println(Arrays.toString(arr));
        int index=binarySearch(arr,82);
        if(index==-1){
            System.out.println("不存在");
        }else{
            System.out.println("存在");
        }
    }
}
