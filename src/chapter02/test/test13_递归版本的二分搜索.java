package chapter02.test;

import java.util.Arrays;

public class test13_递归版本的二分搜索 {
    //because next can not see last ,so transport.函数帧
    static int binarySearch(int[] arr,int target,int left,int right){
        if(left>right) return -1;
        int mid=left+(right-left)/2;
        int midvalue=arr[mid];
        if (midvalue>target){
            return binarySearch(arr,target,left,mid-1);
        }else if(midvalue<target){
            return binarySearch(arr,target,mid+1,right);
        }else{return mid;}

    }
    public static void main(String[] args) {
        int[] arr={23,4,36,434,66,77,86,97,23,68};
        Arrays.sort(arr);
        int index =binarySearch(arr,97,0,9);
        if(index==-1){
            System.out.println("不存在");
        }else{
            System.out.println("存在:"+index);
        }

        }
    }


