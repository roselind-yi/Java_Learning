package homework51.middle;

import java.util.Scanner;

public class h1数组统计 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] nums=new int[5];
        for(int i=0;i<5;i++){
            System.out.println("请输入第"+(i+1)+"个数字。");
            nums[i]=scanner.nextInt();
        }
        int max=nums[0];
        int min=nums[0];
        int sum=0;
        for(int num:nums){
            if(num>max)max=num;
            if(num<min)min=num;
            sum+=num;
        }
        double average=(double) sum/nums.length;
        System.out.println("最大值："+max);
        System.out.println("最小值："+min);
        System.out.println("平均值："+average);

        scanner.close();
    }
}
