package chapter01.test;

public class Test19_等腰三角形 {
    public static void main(String[] args) {
        //外层循环控制行数，内曾循环控制每一行的列数
        int n=5;
        for (int i =1;i<=n;i++){
            //内层1：控制倒三角的空格
            for(int j=n-1-i;j>=0;j--) {//【vital!计算的理解】
                System.out.print(" ");
            }
                //内层2：控制正三角形的*
                    for (int j = 1; j <= 2 * i - 1; j++) {
                        System.out.print("*");
                    }
            System.out.print("\n");//【vital!写在内层结束后的下面！】
        }
    }
}

