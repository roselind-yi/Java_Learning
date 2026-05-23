package homework51.middle;

import java.util.Scanner;

public class h2数组反转 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入数组长度：");
        int length=scanner.nextInt();

        int[] array=new int[length];

        for(int i=0;i<length;i++){
            System.out.print("请输入第"+(i+1)+"个元素。");
            array[i]=scanner.nextInt();
        }
        System.out.print("原数组：【");
        for(int i=0;i<length;i++){
            System.out.print(array[i]+(i<length-1?",":"】\n"));
        }

        int left=0;
        int right=length-1;

        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
        System.out.print("反转后：【");
        for(int i=0;i<length;i++){
            System.out.print(array[i]+(i<length-1 ? "，":"】"));
        }
        scanner.close();

    }
}
