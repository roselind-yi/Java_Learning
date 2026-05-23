package homework51.middle;

import java.util.Scanner;

public class h6数组去重 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("请输入数组长度：");
        int length=scanner.nextInt();

        int[] array=new int[length];
        for(int i=0;i<length;i++){
            System.out.print("请输入第"+(i+1)+"个元素：");
            array[i]=scanner.nextInt();
        }
        if(length==0){
            System.out.print("去重后的数组：[]");
            return;
        }
        int uniqueCount=1;

        for(int i=1;i<length;i++){
            boolean isDuplicate =false;

            for (int j=0;j<uniqueCount;j++){
                if(array[i]==array[j]){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                array[uniqueCount]=array[i];
                uniqueCount++;
            }
        }
        System.out.print("去重后的数组：【");
        for(int i=0;i<uniqueCount;i++){
            System.out.print(array[i]+(i<uniqueCount-1?",":"】"));
        }
        scanner.close();
    }
}
