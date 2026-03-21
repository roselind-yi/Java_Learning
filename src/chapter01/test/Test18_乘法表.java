package chapter01.test;

public class Test18_乘法表 {
    public static void main(String[] args) {
        //外层循环控制行数，内曾循环控制每一行的列数
        for (int i =0;i<10;i++){//【注意1、<=0；0，<9】//反着来的是for(int i=9;i>=0;i--)
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(j*i)+"\t");//正着的方向
            }
            System.out.print("\n");//【vital!写在内层结束后的下面！】
        }
    }
}


