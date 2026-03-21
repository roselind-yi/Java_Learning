package chapter02.test;

public class test01_数组介绍及使用 {
    public static void main(String[] args) {
    //数组的使用
    int[] arr;//声明一个数组
     //arr=10；这是错的，不能移用普通变量的赋值
    arr=new int[5];//大小=长度✖类型的字节数
    //new用于分配新的内存空间，‘5’可换，但是要注意对应int是否可以分配到对应的内存
        System.out.println(arr);//非整数，打印出来的结果是‘[I@1b6d3586’标记了内存的一块区域的地址
    //[]，这是寻址符  //[下表\索引]  英文单词是inedex
        arr[0]=10;//找寻arr指向的内存空间的第0个存储单元
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;
        //arr[5]=60;//最大下标=长度-1；从0开始。故这里是4，所以写5越界了。
        //打印数组种存储的的数据

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);

        System.out.println("but alwasy use 循环打印");
        //i=index；arr.length，返回数组长度。
        for(int i=0;i<5;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");

        System.out.println("用倒叙的打印");
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
    }
}
