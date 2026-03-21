package chapter02.test;

public class test11_数组的搜索 {
    /**
     * 搜索函数
     * arr,被搜索的目标数组
     * target，要搜索的目标值
     * return，目标值在数组中的索引，如果不存在返回-1
     */
    static int search(int[] arr,int target){
        int index=-1;//用于存储目标值的索引，默认-1
        for(int i=0;i<=arr.length;i++)
            if(arr[i]==target){
                index=i;//用index记录此处的索引i
                break;//找到后就可以跳出循环
            }
        return index;
    }

    public static void main(String[] args) {

        int[] arr={23,4,36,434,66,77,86,97,23,68};
        int index=search(arr,77);
        if(index==-1){
            System.out.println("不存在目标值");
        }else{
            System.out.println("存在目标值，索引是："+index);
        }
    }
}
