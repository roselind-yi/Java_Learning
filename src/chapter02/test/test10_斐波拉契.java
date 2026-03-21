package chapter02.test;

public class test10_斐波拉契 {
    static int feibo(int n){
        if(n==1||n==2)return 1;
        int frontOne=feibo(n-1);
        int frontTwo=feibo(n-2);
        return frontOne+frontTwo;
    }
    public static void main(String[] args) {
        for(int n=1;n<=10;n++){
            System.out.println("斐波拉契数列中第"+n+"个数是："+feibo(n));
        }
        System.out.println(feibo(20));
    }
}
