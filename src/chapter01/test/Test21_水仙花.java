package chapter01.test;

public class Test21_水仙花 {
    public static void main(String[] args) {
        //找水仙花数
        //n=个位^3+百^3+千^3
        for(int i=100;i<1000;i++){
            int g=i%10;
            int s=i/10%10;
            int b=i/100;
            //
            //Math.pow(n,指数)
            if(Math.pow(g,3)+Math.pow(s,3)+Math.pow(b,3)==i);
            System.out.println(i+"是水仙花数");
        }
    }
}
