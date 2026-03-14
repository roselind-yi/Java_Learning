package chapter01;

public class Test17 {
    public static void main(String[] args) {
        //打印5行8列的星号矩阵
        //外层循环控制行数，内曾循环控制每一行的列数
        for (int i =1;i<=5;i++){//【注意1、<=5；0，<5】
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.print("\n");//【vital!写在内层结束后的下面！】
        }
    }
}


